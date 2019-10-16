import time

from selenium.webdriver.common.by import By

from base import Base
from task import ContinualTask, LimitedTask, TimerTask
from selenium.webdriver.support import expected_conditions as EC


class Kuaikandian(Base):

    def __init__(self, app_name, udid, device_name, platform_version):
        super().__init__(app_name, udid, device_name, platform_version, 'com.yuncheapp.android.pearl',
                         'com.kuaishou.athena.SplashActivity')

    def home(self):
        self.recover_driver()


class BigWheel(ContinualTask):

    def pre_run(self):
        # 任务tab
        self.base.wait.until(EC.presence_of_all_elements_located((By.ID, 'com.yuncheapp.android.pearl:id/tab_icon_container')))[-1].click()

        size = self.base.size
        self.driver().swipe(int(size['width'] * 0.5),
                            int(size['height'] * 0.8),
                            int(size['width'] * 0.5),
                            int(size['height'] * 0.2),
                            1000)

        self.base.wait.until(EC.presence_of_all_elements_located((By.ID, 'com.yuncheapp.android.pearl:id/rl_button')))[5]\
            .click()

    def run(self):
        time.sleep(2)
        self.driver().tap([(535, 1360)], 100)


class ReadNews(ContinualTask):

    def pre_run(self):
        # 新闻tab
        bottom_tab = self.driver().find_elements_by_id('com.yuncheapp.android.pearl:id/tab_icon_container')
        bottom_tab[0].click()

        # 登录后可能有体现提醒弹窗
        self.driver().back()

    def run(self):
        rect = self.driver().get_window_rect()
        # bug 有可能手机屏幕被碰到了
        # Message: io.appium.uiautomator2.common.exceptions.StaleElementReferenceException: The element 'By.id: com.yuncheapp.android.pearl:id/title' does not exist in DOM anymore
        news = self.driver().find_elements_by_id('com.yuncheapp.android.pearl:id/title')
        for n in news:
            n.click()

            # 进入新闻页面有导航图
            self.driver().tap([(150, 150)], 500)

            start = time.time()
            while True:
                if time.time() - start > 30:
                    break

                self.driver().swipe(int(rect['width'] * 0.5),
                                    int(rect['height'] * 0.75),
                                    int(rect['width'] * 0.5),
                                    int(rect['height'] * 0.5),
                                    1000)
            self.driver().tap([(946, 1688)], 100)
            time.sleep(1)
            self.driver().tap([(490, 974)], 100)
            self.driver().back()

            # 增加阅读时间
            try:
                self.base.wait.until(EC.presence_of_element_located((By.ID, 'com.yuncheapp.android.pearl:id/comment_loc')))
            except:
                self.driver().implicitly_wait(60)
                self.base.wait.until(EC.presence_of_element_located((By.ID, 'com.yuncheapp.android.pearl:id/tt_video_ad_close_layout'))).click()
                print('ok')

            self.driver().back()

        self.driver().swipe(493, 1603, 493, 234, 500)


class SignIn(LimitedTask):

    def run(self):

        # 任务tab
        self.base.wait.until(EC.presence_of_all_elements_located((By.ID, 'com.yuncheapp.android.pearl:id/tab_icon_container')))[-1].click()

        # 领取奖励
        self.base.wait.until(EC.presence_of_element_located((By.ID, 'com.yuncheapp.android.pearl:id/tv_time'))).click()

        # 可能出现微信登陆弹出框
        self.driver().back()


class GoldCoins(TimerTask):

    def __init__(self, base, interval):
        super().__init__(base, interval)

    def run(self):
        self.base.home()

        # 任务tab
        self.base.wait.until(lambda driver: driver.find_elements_by_id('com.yuncheapp.android.pearl:id/tab_icon_container'))[-1].click()

        # 领取奖励
        self.base.wait.until(lambda driver: driver.find_element_by_id('com.yuncheapp.android.pearl:id/tv_time')).click()

        # 视察
        self.base.wait.until(lambda driver: driver.find_element_by_id('com.yuncheapp.android.pearl:id/bg')).click()

        time.sleep(10)
        self.driver().tap([(545, 1162)], 500)
        time.sleep(10)
        self.driver().tap([(545, 1162)], 500)
        time.sleep(10)
        self.driver().tap([(545, 1300)], 500)
        time.sleep(10)
        self.driver().tap([(545, 1500)], 500)
        time.sleep(10)
        self.driver().tap([(916, 1768)], 500)
        self.driver().back()


if __name__ == '__main__':
    # k = Kuaikandian('快看点', 'ab34d0470504', 'xiaomi', '8.1.0')
    # k.add_task([SignIn(k, 1, 1), GoldCoins(k, 60 * 10), ReadNews(k)])
    # k.run()

    k = Kuaikandian('快看点', 'KNH6LV5DKF6HPFMZ', 'redmi', '5.0.2')
    k.add_task([ReadNews(k)])
    k.run()

    # k = Kuaikandian('快看点', 'KNH6LV5DKF6HPFMZ', 'xiaomi', '5.0.2')
    # k.add_task([SignIn(k, 1, 1), GoldCoins(k,  60 * 10), ReadNews(k)])
    # k.run()

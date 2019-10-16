import time
from selenium.common.exceptions import NoSuchElementException, WebDriverException

from base import Base
from task import ContinualTask


class Zhongqingkandian(Base):

    def __init__(self, app_name, udid, device_name, platform_version):
        super().__init__(app_name, udid, device_name, platform_version, 'cn.youth.news', 'com.weishang.wxrd.activity.SplashActivity')

        self.normal_task.append(ReadNews(self))


class ReadNews(ContinualTask):

    def __init__(self, base):
        super().__init__(base)

    def pre_run(self):
        self.authorization()
        self.prepare()

    def run(self):
        self.read()

    def authorization(self):
        self.driver.implicitly_wait(15)
        try:
            shouquan = self.driver.find_element_by_id('cn.youth.news:id/a6x')
            shouquan.click()

            for i in range(3):
                # 授权
                shouquan = self.driver.find_element_by_id('android:id/button1')
                shouquan.click()
                # 不授权
                # not_shouquan = driver.find_element_by_id('android:id/button2')
                # not_shouquan.click()
        except:
            pass

    def prepare(self):
        # 未登录时弹窗
        try:
            pop_up_image = self.driver.find_element_by_id('cn.youth.news:id/a58')
            pop_up_image.click()

            self.driver.back()
        except NoSuchElementException:
            pass

        # 登录时弹窗
        try:
            pop_up_image = self.driver.find_element_by_id('cn.youth.news:id/kn')
            pop_up_image.click()
        except NoSuchElementException:
            pass

    def read(self):
        rect = self.driver.get_window_rect()
        news = self.driver.find_elements_by_id('cn.youth.news:id/a1q')
        for n in news:

            n.click()
            # .until(lambda x: x.find_element_by_xpath('//android.view.View[contains(@text, "查看全文，奖励更多")]'))\
            # .until(lambda x: x.find_element_by_xpath('/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[9]/android.view.View[1]')) \
            # try:
            #     located = {"by": By.XPATH, "value": '//android.view.View[contains(@text, "查看全文，奖励更多")]'}
            #     WebDriverWait(driver, 10) \
            #         .until(visibility_of_element_located(located)) \
            #         .click()
            # # 可能不需要展开， 会有超时异常
            # except TimeoutException:
            #     pass

            start = time.time()
            while True:
                if time.time() - start > 40:
                    break

                # 减少按到不可滑动元素上
                self.driver.swipe(int(rect['width'] * 0.5),
                                  int(rect['height'] * 0.75),
                                  int(rect['width'] * 0.5),
                                  int(rect['height'] * 0.5),
                                  1000)
                self.driver.swipe(int(rect['width'] * 0.5),
                                  int(rect['height'] * 0.5),
                                  int(rect['width'] * 0.5),
                                  int(rect['height'] * 0.3),
                                  1000)

            self.driver.back()

        # 可能有新人邀请弹窗
        # try:
        #     pop_up_image = driver.find_element_by_id('cn.youth.news:id/kn')
        #     pop_up_image.click()
        # except NoSuchElementException:
        #     pass
        self.driver.swipe(493, 1603, 493, 234, 500)


if __name__ == '__main__':
    Zhongqingkandian('中青看点', 'ab34d0470504', 'xiaomi', '8.1.0').run()
    # Zhongqingkandian('中青看点', 'KNH6LV5DKF6HPFMZ', 'redmi', '5.0.2').run()

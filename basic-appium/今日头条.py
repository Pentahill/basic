import time

from selenium.webdriver.common.by import By

from base import Base
from task import ContinualTask
from selenium.webdriver.support import expected_conditions as EC


class Jinritoutiao(Base):

    def __init__(self, app_name, udid, device_name, platform_version):
        super().__init__(app_name, udid, device_name, platform_version, 'com.ss.android.article.lite', 'com.ss.android.article.lite.activity.SplashActivity')


class ReadNews(ContinualTask):

    def pre_run(self):
        # 新闻tab
        self.base.wait.until(EC.presence_of_all_elements_located((By.ID, 'com.ss.android.article.lite:id/ay5')))[0].click()

    def run(self):
        size = self.base.size
        news = self.base.wait.until(EC.presence_of_all_elements_located((By.ID, 'com.ss.android.article.lite:id/d0')))
        for n in news:
            n.click()

            start = time.time()
            while True:
                if time.time() - start > 300:
                    break

                self.driver().swipe(int(size['width'] * 0.5),
                                    int(size['height'] * 0.75),
                                    int(size['width'] * 0.5),
                                    int(size['height'] * 0.6),
                                    1000)

            self.driver().back()

        self.driver().swipe(493, 1603, 493, 234, 500)


if __name__ == '__main__':

    k = Jinritoutiao('今日头条', 'ab34d0470504', 'xiaomi', '8.1.0')
    k.add_task([ReadNews(k)])
    k.run()
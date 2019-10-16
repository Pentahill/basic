from selenium.webdriver.common.by import By
from selenium.webdriver.support.expected_conditions import presence_of_all_elements_located, \
    visibility_of_all_elements_located
from selenium.webdriver.support.wait import WebDriverWait
import time

from base import Base


class Weixin(Base):

    def __init__(self, app_name, udid, device_name, platform_version):
        super().__init__(app_name, udid, device_name, platform_version, 'com.tencent.mm', '.ui.LauncherUI')

    def authentication(self, username, password):
        self.init()

        login_btn = self.driver.find_element_by_id('com.tencent.mm:id/edu')
        login_btn.click()

        phone_input = self.driver.find_element_by_id('com.tencent.mm:id/li')
        phone_input.send_keys(username)
        next_btn = self.driver.find_element_by_id('com.tencent.mm:id/b0f')
        next_btn.click()

        time.sleep(10)
        password_inputs = self.driver.find_elements_by_id('com.tencent.mm:id/li')
        password_inputs[1].send_keys(password)
        next_btn = self.driver.find_element_by_id('com.tencent.mm:id/b0f')
        next_btn.click()


    def read_news(self):
        # 发生错误次数
        error = 0
        self.authorization()
        self.prepare()

        while True:
            try:
                self.read()
            # 错误类型： 1. appium服务错误， 2. 手机端错误
            except WebDriverException:
                logging.exception('[%s] [%s] %s server error' % (self.app_name, self.udid, error))

                # 服务器错误过多，退出运行
                error += 1
                if error > 10:
                    logging.error('[%s] [%s] 错误过多，退出运行' % (self.app_name, self.udid))
                    break

                # 重启服务
                self.recover_driver()
                self.authorization()
                self.prepare()

            except NoSuchElementException:
                self.home()
                logging.exception('[%s] no such element' % self.app_name)


if __name__ == '__main__':
    import threading
    # w1 = Weixin('微信', 'ab34d0470504', 'xiaomi', '8.1.0')
    w2 = Weixin('微信', 'KNH6LV5DKF6HPFMZ', 'hongmi', '5.0.2')
    # threading.Thread(target=w1.login, args=('17740885731', '1990liujinyao', )).start()
    threading.Thread(target=w2.authentication, args=('16628419084', '1990liujinyao',)).run()

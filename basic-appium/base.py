import logging
import threading
import queue
from threading import Timer
from appium import webdriver
from selenium.common.exceptions import NoSuchElementException, WebDriverException, InvalidSessionIdException
from selenium.webdriver.support.wait import WebDriverWait

from task import TimerTask


class Base(object):

    def __init__(self, app_name, udid, device_name, platform_version, app_package, app_activity):
        self.normal_task = queue.PriorityQueue()
        self.timer_task = []

        self.caps = {'automationName': 'UIAutomator2',
                     'uiautomator2ServerLaunchTimeout': '60000',
                     'platformName': 'Android',
                     'udid': udid,
                     'deviceName': device_name,
                     'platformVersion': platform_version,
                     'noReset': 'True',
                     'newCommandTimeout': '800',
                     'appPackage': app_package,
                     'appActivity': app_activity}

        self.udid = udid
        self.executor = 'http://localhost:4723/wd/hub'
        self.app_name = app_name

        self.lock_ = None
        self.error = 0
        self.driver = None
        self.wait = None
        self.size = None

        self.new_driver()

    def new_driver(self):
        logging.info('[%s] [%s] %s' % (self.app_name, self.udid, '启动driver'))

        self.driver = webdriver.Remote(command_executor=self.executor, desired_capabilities=self.caps)
        self.wait = WebDriverWait(self.driver, 10)
        self.size = self.driver.get_window_size()

    # 启动driver, 启动应用后的授权，进入应用后的初始化工作
    def recover_driver(self):

        self.new_driver()
        try:
            self.lock()
            self.init()
        finally:
            self.unlock()

    # 进入应用后的初始化工作
    def init(self):
        pass

    # 添加任务到队列中
    def add_task(self, tasks):
        for t in tasks:
            if isinstance(t, TimerTask):
                self.timer_task.append(t)
            else:
                self.normal_task.put(t)

    # 所有任务运行完成
    def end(self):
        self.driver.close()

    # 回到应用首页
    def home(self):
        pass

    def execute(self):

        self.lock_ = threading.Lock()

        # 设置定时任务
        self.timer()

        while self.normal_task:
            task = self.normal_task.get()
            try:
                task.execute()
            except WebDriverException:
                logging.exception('driver error')
                logging.error('[%s] [%s] driver error' % (self.app_name, self.udid))
                # debug模式输出错误信息

                # 服务器错误过多，退出运行
                self.error += 1
                if self.error > 10:
                    logging.error('[%s] [uuid: %s] 错误过多，退出运行' % (self.app_name, self.udid))
                    raise Exception('driver error too many')

                # 重启服务
                self.recover_driver()
            except NoSuchElementException:
                logging.exception('[%s] [%s] no such element' % (self.app_name, self.udid))
                self.home()
            finally:
                if not task.is_over():
                    self.normal_task.put(task)

    def time_execute(self, task):

        try:
            task.pre_run()
            task.run()
            task.post_run()
        except WebDriverException:
            logging.exception('driver error')
            logging.error('[%s] [%s] driver error' % (self.app_name, self.udid))

            # 服务器错误过多，退出运行
            self.error += 1
            if self.error > 10:
                logging.error('[%s] [uuid: %s] 错误过多，退出运行' % (self.app_name, self.udid))
                raise Exception('driver error too many')

            # 重启服务
            self.recover_driver()
        except NoSuchElementException:
            logging.exception('[%s] [%s] no such element' % (self.app_name, self.udid))
            self.home()

        Timer(task.interval, self.time_execute, (task,)).start()

    def run(self):
        threading.Thread(target=self.execute).start()

    def lock(self):
        self.lock_.acquire()

    def unlock(self):
        self.lock_.release()

    # 设置定时任务
    def timer(self):
        try:
            self.lock()
            for t in self.timer_task:
                Timer(t.interval, self.time_execute, (t,)).start()
        finally:
            self.unlock()

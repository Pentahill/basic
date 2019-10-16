import time
import operator
from threading import Timer


class Task(object):

    def __init__(self, base, priority=-1):
        self.base = base
        self.app_name = base.app_name
        self.udid = base.udid
        self.error = base.error
        self.priority = priority

    def is_over(self):
        return False

    def driver(self):
        return self.base.driver

    # 处理driver报错问题
    def execute(self):

        try:
            self.base.lock()
            self.pre_run()
            self.run()
            self.post_run()
        finally:
            self.base.unlock()
            time.sleep(1)

    def pre_run(self):
        pass

    def run(self):
        pass

    def post_run(self):
        pass

    def __lt__(self, other):
        return self.priority > other.priority


class LimitedTask(Task):

    def __init__(self, base, number, priority=-1):
        self.number = number
        super().__init__(base, priority)

    def is_over(self):
        return self.number <= 0

    def execute(self):
        try:
            self.pre_run()
            self.base.lock()
            self.run()
            self.post_run()
        finally:
            self.number -= 1
            self.base.unlock()
            time.sleep(1)


class ContinualTask(Task):

    def __init__(self, base, priority=-1):
        super().__init__(base, priority)

    def execute(self):

        try:
            self.base.lock()
            self.pre_run()
            while True:
                self.run()
            self.post_run()
        finally:
            self.base.unlock()
            time.sleep(10)


class TimerTask(Task):

    def __init__(self, base, interval, priority=-1):
        super().__init__(base, priority)
        self.interval = interval

from 中青看点 import Zhongqingkandian
from 快看点 import Kuaikandian
from 快看点 import SignIn, GoldCoins, ReadNews
from 今日头条 import Jinritoutiao, ReadNews as Jin_r


if __name__ == '__main__':
    udids = ['ab34d0470504', 'KNH6LV5DKF6HPFMZ']
    device_names = ['xiaomi', 'redmi']
    platform_versions = ['8.1.0', '5.0.2']

    for udid, device_name, platform_version in zip(udids, device_names, platform_versions):
        # k = Jinritoutiao('今日头条', udid, device_name, platform_version)
        # k.add_task([Jin_r(k)])
        # k.run()

        k = Kuaikandian('快看点', udid, device_name, platform_version)
        k.add_task([ReadNews(k)])
        k.run()
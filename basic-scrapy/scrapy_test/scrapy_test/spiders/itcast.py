import scrapy
from scrapy import cmdline


class ItemSpider(scrapy.Spider):
    name = 'itcast'
    allowed_domains = ['baidu.com']
    start_urls = ['https://docs.scrapy.org/en/latest/']

    def start_requests(self):
        return super().start_requests()

    def parse(self, response):
        img_src = response.xpath('//span[has-class("caption-text")]/text()').getall()
        page = response.url.split("/")[-2]
        filename = 'quotes-%s.html' % page
        with open(filename, 'wb') as f:
            f.write(response.body)

        self.log('Saved file %s' % filename)

cmdline.execute("scrapy crawl itcast".split());
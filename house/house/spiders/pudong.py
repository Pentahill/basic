import scrapy

def start_urls():
    return [f'https://sh.lianjia.com/xiaoqu/pudong/pg{i}' for i in range(1, 31)]

print(start_urls())        

class Pudong(scrapy.Spider):
    name = "pudong"
    start_urls = start_urls()

    def parse(self, response):

        names = response.css('div.info div.title a::text').getall()
        prices = response.css('div.totalPrice span::text').getall()
        for name, price in zip(names, prices):
            yield {
                'name': name,
                'price': price
            }
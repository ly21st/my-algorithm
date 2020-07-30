# -*- coding: utf-8 -*-
import scrapy
from maoyanmovie.items import MaoyanmovieItem
from scrapy.selector import Selector
import time

url_prefix = 'https://maoyan.com'

class MaoyanSpider(scrapy.Spider):
    name = 'maoyan'
    allowed_domains = ['maoyan.com']
    start_urls = ['https://maoyan.com/films?showType=3']

    # def parse(self, response):
    #     pass

    def start_requests(self):
        url = f'https://maoyan.com/films?showType=3'
        yield scrapy.Request(url=url, callback=self.parse)

    def parse(self, response):
        # 打印网页url
        print(response.url)
        # 打印网页内容
        # print(response.text)

        # dd_nodes = Selector(response=response).xpath('//*[@id="app"]/div/div[2]/div[2]/dl[@class="movie-list"]/dd')
        dd_nodes = Selector(response=response).xpath('//*[@id="app"]/div/div[2]/div[2]/dl[@class="movie-list"]/*')



        print('urls:', dd_nodes)
        print('len(urls):', len(dd_nodes))
        # print(''.join(dd_nodes.extract()))

        name = Selector(response=response).xpath('//*[@id="app"]/div/div[2]/div[2]/dl[@class="movie-list"]/dd[1]/div[1]/div[2]/a/div/div[1]/span[1]')
        print('name:', name.extract())
        name = Selector(response=response).xpath('//*[@id="app"]/div/div[2]/div[2]/dl[@class="movie-list"]/dd[1]/div[1]/div[2]/a/div/div[2]/span')
        print('type:', name.extract())

        name = Selector(response=response).xpath('//*[@id="app"]/div/div[2]/div[2]/dl[@class="movie-list"]/dd[2]/div[1]/div[2]/a/div/div[1]/span[1]')
        print('name:', name.extract())
        name = Selector(response=response).xpath('//*[@id="app"]/div/div[2]/div[2]/dl[@class="movie-list"]/dd[2]/div[1]/div[2]/a/div/div[2]/span')
        print('type:', name.extract())

        item = MaoyanmovieItem()



        return

        for url in urls:
            time.sleep(1)
            link = url_prefix + url
            yield scrapy.Request(url=link, callback=self.parse2)

    def parse2(self, response):
        # 打印网页的url
        print("")
        print(response.url)

        movie_container = Selector(response=response).xpath('//div[1][@class="movie-brief-container"]')
        print('movie_container:', movie_container)
        if (not movie_container):
            return



        item = MaoyanmovieItem()
        movie_container = movie_container[0]
        filename = movie_container.xpath('./h1[@class="name"]/text()')
        print('filename:', filename)
        item['title'] = " ".join(filename.extract())

        file_type = movie_container.xpath('./ul/li[1]/a/text()')
        print('file_type:', file_type)
        item['type'] = "/".join(file_type.extract())

        film_date = movie_container.xpath('./ul/li[3]/text()')
        print('file_date:', film_date)  
        item['film_date'] = " ".join(film_date.extract())

        print('item：', item)
        yield item
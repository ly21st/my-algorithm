# -*- coding: utf-8 -*-

# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://docs.scrapy.org/en/latest/topics/item-pipeline.html

import pandas as pd

class MaoyanmoviePipeline:
    # def process_item(self, item, spider):
    #     return item

    
    def process_item(self, item, spider):
        title = item['title']
        type = item['type']
        film_date = item['film_date']

        move_data = [[title, type, film_date]]
        df = pd.DataFrame(data=movie_list, columns=('标题', '类型', '上映时间'))
        df.to_csv("./movies.csv", encoding='utf8', index=False, header=False, mode='a+')
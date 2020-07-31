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
        if not item:
            return
        move_data = [[item['title'], item['film_type'], item['film_date']]]
        df = pd.DataFrame(data=move_data, columns=('标题', '类型', '上映时间'))
        df.to_csv("./movies.csv", encoding='gbk', index=False, header=False, mode='a+')
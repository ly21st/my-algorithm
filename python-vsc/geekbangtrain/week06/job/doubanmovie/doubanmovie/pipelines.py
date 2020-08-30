# -*- coding: utf-8 -*-

# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://docs.scrapy.org/en/latest/topics/item-pipeline.html

import pandas as pd
import pymysql
import traceback


class DoubanmoviePipeline:
    # def process_item(self, item, spider):
    #     return item

    def __init__(self, config):
            self.config = config

    @classmethod
    def from_crawler(cls, crawler):
        return cls(crawler.settings.get('MYSQL_CONFIG'))

    def open_spider(self, spider):
        self.conn = pymysql.connect(
            host=self.config['host'],
            port=self.config['port'],
            user=self.config['user'],
            password=self.config['password'],
            db=self.config['db']
        )

    def close_spider(self, spider):
        self.conn.close()

    def process_item(self, item, spider):
        if not item:
                return

        with self.conn.cursor() as cur:
            sql = "INSERT INTO `movies` (`name`, `tag`, `plan_date`) VALUES (%s, %s, %s)"
            cur.execute(sql, (item['name'], item['tag'], item['plan_date']))
        self.conn.commit()
        return item


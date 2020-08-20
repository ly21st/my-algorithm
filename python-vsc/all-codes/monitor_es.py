# -*- coding: utf-8 -*-

import time
import requests
import traceback
import datetime
import json


class Result(object):
    def __init__(self):
        self.init_res = {}
        self.last_res = {}
        self.res = {}


def get_es_data_and_save(url, fp, result):
    res = {}

    try:
        # 获取以及输出时间
        now_time = time.time()
        res['timestamp'] = now_time
        res['datetime'] = datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S:%f')[:-3]
        res['time'] = datetime.datetime.now().strftime('%H:%M:%S:%f')[:-3]

        # 获取es统计
        response = requests.get(url)
        if response.status_code != 200:
            print('response.status_code:', response.status_code)
            print("response error:", response.reason)
            return

        body = response.json()
        # print(json.dumps(body, indent=4))
        res['_shards'] = body['_shards']
        res['_all'] = body['_all']

        # 计算统计信息
        if result.init_res:
            primary_bytes = res['_all']['primaries']['store']['size_in_bytes'] - \
                            result.init_res['_all']['primaries']['store']['size_in_bytes']
            primary_docs = res['_all']['primaries']['docs']['count'] - result.init_res['_all']['primaries']['docs'][
                'count']

            total_bytes = res['_all']['total']['store']['size_in_bytes'] - result.init_res['_all']['total']['store'][
                'size_in_bytes']
            total_docs = res['_all']['total']['docs']['count'] - result.init_res['_all']['total']['docs']['count']

            diff_time = now_time - result.init_res['timestamp']
            throughput = 0
            if diff_time:
                throughput = primary_bytes * 1.0 / diff_time
            res['stats'] = {}
            res['stats']['primary_bytes'] = primary_bytes
            res['stats']['primary_docs'] = primary_docs
            res['stats']['total_bytes'] = total_bytes
            res['stats']['total_docs'] = total_docs
            res['stats']['diff_time'] = diff_time
            res['stats']['throughput'] = throughput
        else:
            result.init_res = res

        if result.last_res:
            recent_time_diff = res['timestamp'] - result.last_res['timestamp']
            if recent_time_diff:
                recent_primary_throughput = (res['_all']['primaries']['store']['size_in_bytes'] - \
                                             result.last_res['_all']['primaries']['store'][
                                                 'size_in_bytes']) / recent_time_diff
                recent_total_throughput = (res['_all']['total']['store']['size_in_bytes'] -
                                           result.last_res['_all']['total']['store'][
                                               'size_in_bytes']) / recent_time_diff
                res['stats']['recent_primary_throughput'] = recent_primary_throughput
                res['stats']['recent_total_throughput'] = recent_total_throughput

        result.last_res = res

        print(json.dumps(res, ensure_ascii=False, indent=4))
        json.dump(res, fp=fp, ensure_ascii=False, indent=4)
        fp.write('\n')
        fp.flush()
    except Exception as e:
        print(traceback.format_exc())


if __name__ == '__main__':
    try:
        result = Result()
        url = "http://10.8.4.43:30093/_stats/store,docs?index=afa*"
        # url = "http://10.8.4.13:30093/_stats/store,docs?index=.monitoring-es*"
        fp = open("es_output.json", "a+", encoding='utf-8')
        while True:
            get_es_data_and_save(url, fp, result)
            time.sleep(10)
    except Exception as e:
        print(traceback.format_exc())

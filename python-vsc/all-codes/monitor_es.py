# -*- coding: utf-8 -*-

import time
import requests
import traceback
import datetime
import json


def get_es_data_and_save(url, fp):
    res = {}
    try:
        # print('------------------------')
        # print(datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S:%f')[:-3])
        fp.write('\n------------------------\n')
        fp.write(datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S:%f')[:-3])
        fp.write("\n")
        response = requests.get(url)
        if response.status_code != 200:
            print('response.status_code:', response.status_code)
            print("response error:", response.reason)
            return

        body = response.json()
        # print(json.dumps(body, indent=4))
        res['_shards'] = body['_shards']
        res['_all'] = body['_all']
        # print(json.dumps(res, indent=4))
        # json.dump(res, fp=fp, ensure_ascii=False, indent=4)
        json.dump(res, fp=fp, ensure_ascii=False)
        fp.flush()
    except Exception as e:
        print(traceback.format_exc())


if __name__ == '__main__':
    while True:
        url = "http://10.8.4.13:30093/_stats/store,docs?index=afa*"
        # url = "http://10.8.4.13:30093/_stats/store,docs?index=.monitoring-es*"
        fp = open("es_output.json", "a+", encoding='utf-8')
        get_es_data_and_save(url, fp)
        time.sleep(10)
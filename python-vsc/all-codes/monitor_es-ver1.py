# -*- coding: utf-8 -*-

import time
import requests
import traceback
import datetime
import json

glb_begin_res = None
glb_begin_time = None


def get_es_data_and_save(url, fp):
    res = {}
    global glb_begin_time
    global glb_begin_res

    try:
        # print('------------------------')
        # print(datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S:%f')[:-3])
        fp.write('\n------------------------\n')
        # 获取以及输出时间
        now_time = time.time()

        if not glb_begin_time:
            glb_begin_time = now_time
        time_format = "time:{}\n".format(now_time)
        fp.write(time_format)
        fp.write(datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S:%f')[:-3])
        fp.write("\n")

        print('begin_res')

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

        if not glb_begin_res:
            glb_begin_res = res
        print(json.dumps(res, indent=4))
        # json.dump(res, fp=fp, ensure_ascii=False, indent=4)
        json.dump(res, fp=fp, ensure_ascii=False)

        # 计算统计信息
        primary_bytes = res['_all']['primaries']['store']['size_in_bytes'] - \
                        glb_begin_res['_all']['primaries']['store'][
                            'size_in_bytes']
        primary_docs = res['_all']['primaries']['docs']['count'] - glb_begin_res['_all']['primaries']['docs']['count']

        total_bytes = res['_all']['total']['store']['size_in_bytes'] - glb_begin_res['_all']['total']['store'][
            'size_in_bytes']
        total_docs = res['_all']['total']['docs']['count'] - glb_begin_res['_all']['total']['docs']['count']

        diff_time = now_time - glb_begin_time
        throughput = 0
        if primary_bytes and diff_time:
            throughput = primary_bytes * 1.0 / diff_time
        status_output = "\nprimaries bytes:{}, primaries docs:{}, total bytes:{}, total docs:{}, time consuming:{}, throughput:{}\n".format(
            primary_bytes, primary_docs, total_bytes, total_docs, diff_time, throughput)
        print(status_output)
        fp.write(status_output)
        fp.flush()

        print('glb_begin_time:', glb_begin_time)
        print('glb_begin_res:', glb_begin_res)

    except Exception as e:
        print(traceback.format_exc())


if __name__ == '__main__':
    while True:
        url = "http://10.8.4.13:30093/_stats/store,docs?index=afa*"
        # url = "http://10.8.4.13:30093/_stats/store,docs?index=.monitoring-es*"
        fp = open("es_output.json", "a+", encoding='utf-8')
        get_es_data_and_save(url, fp)
        time.sleep(10)

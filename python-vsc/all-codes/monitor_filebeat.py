# -*- coding: utf-8 -*-

import time
import requests
import traceback
import datetime
import json
import copy


class Result(object):
    def __init__(self):
        self.init_res = {}
        self.last_res = {}
        self.res = {}


def get_filebeat_data_and_save(url, fp, result, ip):
    res = {}

    try:
        # print('------------------------')
        # print(datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S:%f')[:-3])
        # 获取以及输出时间
        now_time = time.time()
        res['timestamp'] = now_time
        res['datetime'] = datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S:%f')[:-3]
        res['time'] = datetime.datetime.now().strftime('%H:%M:%S:%f')[:-3]
        res['ip'] = ip

        # 获取es统计
        response = requests.get(url)
        if response.status_code != 200:
            print('response.status_code:', response.status_code)
            print("response error:", response.reason)
            return

        body = response.json()
        # print(json.dumps(body, indent=4))

        # 计算统计信息
        res['stats'] = {}
        res['stats']['uptime_ms'] = body['beat']['info']['uptime']['ms']
        write_bytes = body['libbeat']['output']['write']['bytes']
        res['stats']['write_bytes'] = write_bytes

        rss = body['beat']['memstats']['rss']
        res['stats']['rss'] = rss

        if result.init_res:
            diff_uptime_ms = res['stats']['uptime_ms'] - result.init_res['stats']['uptime_ms']
            res['stats']['diff_uptime_sec'] = diff_uptime_ms / 1000.0
            if diff_uptime_ms < 0:
                res['stats']['restart'] = (res['stats'].get('restart') or 0) + 1
                result.init_res = res

            diff_write_bytes = write_bytes - result.init_res['stats']['write_bytes']
            res['stats']['diff_write_bytes'] = diff_write_bytes

            diff_time = now_time - result.init_res['timestamp']
            res['stats']['diff_time'] = diff_time

            throughput = 0
            if diff_time:
                throughput = diff_write_bytes * 1.0 / diff_time
            res['stats']['throughput'] = throughput
        else:
            result.init_res = res

        result.last_res = res
        print(json.dumps(res, ensure_ascii=False, indent=4))
        # json.dump(res, fp=fp, ensure_ascii=False, indent=4)
        fp.write('\n')
        fp.flush()
    except Exception as e:
        print(traceback.format_exc())


if __name__ == '__main__':
    try:
        urls = ["http://10.8.4.13:5066/stats", "http://10.8.4.43:5066/stats", "http://10.8.4.73:5066/stats"]
        outputs = ["filebeat13.json", "filebeat43.json", "filebeat73.json"]
        fps = []
        for output in outputs:
            fp = open(output, "a+", encoding='utf-8')
            fps.append(fp)
        init_res_list = [Result(), Result(), Result()]
        ips = ['10.8.4.13', '10.8.4.43', '10.8.4.73']
        while True:
            for i in range(len(urls)):
                get_filebeat_data_and_save(urls[i], fps[i], init_res_list[i], ips[i])

            time.sleep(10)
    except Exception as e:
        print(traceback.format_exc())

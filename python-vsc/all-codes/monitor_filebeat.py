# -*- coding: utf-8 -*-

import time
import requests
import traceback
import datetime
import json
import urllib3.exceptions


class Result(object):
    def __init__(self):
        self.init_res = {}
        self.last_res = {}
        self.res = {}
        self.restart = 0


def get_filebeat_data_and_save(url, fp, result, ip):
    res = {}

    try:
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
        res['stats']['write_bytes'] = body['libbeat']['output']['write']['bytes']

        rss = body['beat']['memstats']['rss']
        res['stats']['rss'] = rss

        if result.init_res:
            diff_uptime_ms = res['stats']['uptime_ms'] - result.init_res['stats']['uptime_ms']
            res['stats']['diff_uptime_sec'] = diff_uptime_ms / 1000.0
            if diff_uptime_ms < 0:
                result.restart = result.restart + 1
                result.init_res = res
                print("Error: 重启filebeat次数为:" + str(result.restart))
                fp.write("Error: 重启filebeat次数为:" + str(result.restart) + "\n")

            diff_write_bytes = res['stats']['write_bytes'] - result.init_res['stats']['write_bytes']
            res['stats']['diff_write_bytes'] = diff_write_bytes

            run_times = now_time - result.init_res['timestamp']
            res['stats']['run_times'] = run_times

            throughput = 0
            if run_times:
                throughput = diff_write_bytes * 1.0 / run_times
            res['stats']['throughput'] = throughput / 1024
        else:
            result.init_res = res

        if result.last_res:
            recent_time_diff = res['stats']['uptime_ms'] - result.last_res['stats']['uptime_ms']
            if recent_time_diff / 1000:
                recent_throughput = (res['stats']['write_bytes'] - result.last_res['stats']['write_bytes']) / (
                            recent_time_diff / 1000.0)
                res['stats']['recent_throughput'] = recent_throughput / 1024

        result.last_res = res
        result.res = res
        print(json.dumps(res, ensure_ascii=False, indent=4))
        json.dump(res, fp=fp, ensure_ascii=False, indent=4)
        fp.write('\n')
        fp.flush()
    except (requests.exceptions.ConnectionError, urllib3.exceptions.NewConnectionError) as e:
        print("ConnectionError:", e)
        fp.write(str(e))
        fp.write('\n')
        fp.flush()
    except Exception as e:
        print(traceback.format_exc())


if __name__ == '__main__':
    try:
        urls = ["http://10.8.4.13:5066/stats", "http://10.8.4.43:5066/stats", "http://10.8.4.73:5066/stats"]
        # outputs = ["filebeat13.json", "filebeat43.json", "filebeat73.json"]
        # fps = []
        # for output in outputs:
        #     fp = open(output, "a+", encoding='utf-8')
        #     fps.append(fp)
        fp = open("filebeat.json", "a+", encoding='utf-8')
        init_res_list = []
        for i in range(len(urls)):
            init_res_list.append(Result())
        ips = ['10.8.4.13', '10.8.4.43', '10.8.4.73']
        while True:
            for i in range(len(urls)):
                get_filebeat_data_and_save(urls[i], fp, init_res_list[i], ips[i])

            # 汇总各个filebeat的结果
            all_recent_throughput = 0
            all_throughput = 0
            for i in range(len(urls)):
                all_throughput = all_throughput + (init_res_list[i].res['stats'].get('throughput') or 0)
                all_recent_throughput = all_recent_throughput + (init_res_list[i].res['stats'].get('recent_throughput') or 0)
            all_result = {
                'all_throughput': all_throughput,
                'all_recent_throughput': all_recent_throughput
            }
            print(json.dumps(all_result, ensure_ascii=False, indent=4))
            json.dump(all_result, fp=fp, ensure_ascii=False, indent=4)
            fp.write('\n')
            fp.flush()
            time.sleep(10)
    except Exception as e:
        print(traceback.format_exc())
    finally:
        if fp:
            fp.flush()
            fp.close()

# -*- coding:utf-8 -*-

import collections

bag = ['apple', 'orange', 'cherry', 'apple','apple', 'cherry', 'blueberry']
count = collections.defaultdict(int)
for fruit in bag:
    count[fruit] += 1
print("count:", count)


# def _requestUrl(index):
#     src_url = 'http://www.xicidaili.com/nt/'
#     url = src_url + str(index)
#     if index == 0:
#         url = src_url

#     headers = {
#         'User-Agent': 'Mozilla/5.0 (Windows NT 6.3; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0'
#     }
#     response = requests.get(url, headers=headers)
#     return response.text

# import requests

_requestUrl(0)
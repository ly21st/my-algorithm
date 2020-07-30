# -*- coding:utf-8 -*-
import pretty_errors
import requests
import lxml.etree
import time

url_prefix = 'https://maoyan.com'
user_agent = 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.163 Safari/537.36'
g_cookie = 'BAIDUID=D126D771780BE7E1CA2BBDA0C02E2656:FG=1; PSTM=1591869598; BIDUPSID=19E85EC71F6F9FD8DE0CE1549A8399B9; BDUSS=UxUmRaQ2dJOEhJckxMT0o4Y3RGMDZ2ZUNGc0d1UC1zZHhZV1VZaHJDWHJ-eGhmSVFBQUFBJCQAAAAAAAAAAAEAAAARU94ObHkyMXN0AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAOty8V7rcvFeMz; BDSFRCVID=9gKsJeCCxG3eZnjuPwlq8NiMO178jxL3ye5G3J; H_BDCLCKID_SF=tRk8oDt5fCvJJ6rmbtOhq4tHePtJBRJZ5m7mXp0bWIoBMP5Mb4nAe-0l5f7MQjOGL4jkhUjvaKOkbCIwj5Kae5JMbpCXatoqK4oJ0RbaHJO_bI0zQMnkbfJBDxrg-p5IKjTT0fQjfn05Vt_4qq6kh6K7yajK2M52-GkJ2bRyW4cMhPT45xQpQT8rhn_OK5Oib4jb5lCyab3vOIOTXpO1jM0zBN5thURB2DkO-4bCWJ5TMl5jDh3Mb6ksDMDtqjtjJJktoDIKfbvHjt3Gq4vHbP40qxby26n8Wnn9aJ5nJDoS_pOSKPbh0b-b2G7MJhoHBTcH_nr_QpP-HJ7zM5o0Q5tR0ao234ozbTcnKl0MLUOtbb0xyUQDetLq3xnMBMPe52OnaIbg3fAKftnOM46JehL3346-35543bRTLnLy5KJtMDF4DT--D5v0eHRf-b-X2K60Bb5tK6rjDnCr5UJOXUI82h5y05J72bKtLxJ5aUPWeIOhK65vyToWXnORXx74fRnnbUFhJDbYMKnKX44VyxL1Db3Jb-rIaGQR3Do2JCboepvoD-Jc3MvByPjdJJQOBKQB0KnGbUQkeq8CQft20b0EeMtjW6LEtJAe_DtyJCI3H48k-4QEbbQH-UnLqMvLLgOZ04n-ah05ObkwjJom5P7yeMteQRDHW20D_h7m3UTdsq76Wh35K5tTQP6rLf6WHmQ4KKJxbPOVVJ6LQ-KK55Q3hUJiB5OMBan7_qvIXKohJh7FM4tW3J0ZyxomtfQxtNRJ0DnjtpChbC_wD6t-jTcQeUOfhD62aJ080hvbWJ5TEPnjDPoAh4I00hJQb6vw2mj9oC0y2tndhPTNjft5y6ISKx-_J688JbRP; Hm_lvt_6859ce5aaf00fb00387e6434e4fcc925=1594867371,1594867987,1594947675,1595467968; BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; delPer=0; PSINO=6; BDRCVFR[feWj1Vr5u3D]=I67x6TjHwwYf0; H_PS_PSSID=32292_1451_32380_31660_32046_32115_32297_32261; ZD_ENTRY=empty; shitong_key_id=2; Hm_lpvt_6859ce5aaf00fb00387e6434e4fcc925=1595905219; shitong_data=fd5c2e5862bdbe7e628c930f5665dce87c5d3c25f1ddbe1d4ddf25e1efb8638f01a9139c26c943fea17b5d5355d3286ea1b838321c58bde081b382b4e9d1f26da3bf7f6494e00f8cc630dbaa46c675a052fab1847c8019011fd71ee7de01f336f104c4840ee3a349e163656b7fefe7c0479ee2e3147c3c4ece8832942fab269d; shitong_sign=7f8dae7c'
g_host = 'zhidao.baidu.com'
g_encoding = 'gzip, deflate, br'
g_language = 'zh-CN,zh;q=0.9'
g_accept = 'application/json, text/javascript, */*; q=0.01'

def get_url(myurl):
    header = {'user-agent': user_agent}
    header['Cookie'] = g_cookie
    header['Host'] = g_host
    header['Accept-Encoding']= g_encoding
    header['Accept-Language'] = g_language
    header['Accept'] = g_accept
    # header['X-ik-ssl'] = '1'
    # header['X-Requested-With'] = 'XMLHttpRequest'

    response = requests.get(myurl, headers=header)
    # print(response.text)

    selector = lxml.etree.HTML(response.text)
    url_list = selector.xpath('//*[@id="wgt-list"]/dl[1]/dt/a/@href')
    print("url_list:", url_list)
    return [url for url in url_list[:1]]


def get_answer_info(myurl):
    header = {'user-agent': user_agent}
    header['Cookie'] = g_cookie
    header['Host'] = g_host
    header['Accept-Encoding']= g_encoding
    header['Accept-Language'] = g_language
    header['Accept'] = g_accept
    # header['X-ik-ssl'] = '1'
    # header['X-Requested-With'] = 'XMLHttpRequest'
    response = requests.get(myurl, headers=header)
    response.encoding = response.apparent_encoding
    print(response.text)

    # selector = lxml.etree.HTML(response.text)
    # str = response.content
    # str = str.decode('gb2312')
    # selector = lxml.etree.HTML(str)

    print('response.apparent_encoding:', response.apparent_encoding)
    selector = lxml.etree.HTML(response.text)

    answers = selector.xpath('//div[@accuse="aContent"]')
    # print("answer:", answers)

    for answer in answers:
        print(" ")
        answer_content = answer.xpath("./text()")
        # print('answer_content:', answer_content)
        # print("answer_content:", "".join(answer_content).decode('UTF-8').encode('GBK'))
        print("answer_content:", "".join(answer_content))

        
    return 

    movie_info = []
    # movie_info.append(myurl)
    movie_container = selector.xpath('//div[1][@class="movie-brief-container"]')
    print('movie_container:', movie_container)
    if (not movie_container):
        return

    movie_container = movie_container[0]
    filename = movie_container.xpath('./h1[@class="name"]/text()')
    print('filename:', filename)
    movie_info.append(" ".join(filename))

    file_type = movie_container.xpath('./ul/li[1]/a/text()')
    print('file_type:', file_type)
    movie_info.append("/".join(file_type))

    file_date = movie_container.xpath('./ul/li[3]/text()')
    print('file_date:', file_date)
    movie_info.append(" ".join(file_date))

    return movie_info


def get_baidu_answer_info(url):
    urls = get_url(url)

    for url in urls:
        print(url)
        # time.sleep(5)
        get_answer_info(url)



get_baidu_answer_info('https://zhidao.baidu.com/search?lm=0&rn=10&pn=0&fr=search&ie=gbk&word=%C8%E7%BA%CE%B7%A2%B2%C6')
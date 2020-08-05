# 秘钥长度正常24位，16位补齐第一个八位
import pyDes
import base64
#
print('=======key1=======')
keys = '1234567890123456'
k = pyDes.triple_des(keys, pyDes.ECB, "\0\0\0\0\0\0\0\0", pad=None, padmode=pyDes.PAD_PKCS5)
d = k.encrypt("137613")
print(base64.b64encode(d))
e = k.decrypt(d)
print(e)


print('=======key2=======')
keys2 = '123456789012345612345678'
k2 = pyDes.triple_des(keys2, pyDes.ECB, "\0\0\0\0\0\0\0\0", pad=None, padmode=pyDes.PAD_PKCS5)
d2 = k2.encrypt("137613")
print(base64.b64encode(d2))
e2 = k2.decrypt(d2)
print(e2)



#
print('=======key3=======')
keys3 = '123456789090909090909090'
k3 = pyDes.triple_des(keys3, pyDes.ECB, "\0\0\0\0\0\0\0\0", pad=None, padmode=pyDes.PAD_PKCS5)
d3 = k3.encrypt("137613")
print(base64.b64encode(d3))

e3 = k3.decrypt(d3)
print(e3)
# J01CKsP9aIcsXbqFmSYlbw==



#
# 秘钥长度不正常10位,通过空字符来补齐,先加密再解密
import pyDes
import base64

keys = '1234567890' + chr(0) + chr(0) + chr(0) + chr(0) + chr(0) + chr(0) + chr(0) + chr(0) + chr(0) + chr(0) + chr(
    0) + chr(0) + chr(0) + chr(0)
k = pyDes.triple_des(keys, pyDes.ECB, "\0\0\0\0\0\0\0\0", pad=None, padmode=pyDes.PAD_PKCS5)
d = k.encrypt("17862299")
print('-------------')
print(d)
print(base64.b64encode(d))

e = k.decrypt(d)
print(e)
# jnjOe8CdrxROEwvCu58T4w==

# 秘钥长度不正常10位,通过空字符来补齐，直接解密
import pyDes
import base64

keys = '1234567890' + chr(0) + chr(0) + chr(0) + chr(0) + chr(0) + chr(0) + chr(0) + chr(0) + chr(0) + chr(0) + chr(
    0) + chr(0) + chr(0) + chr(0)
k = pyDes.triple_des(keys, pyDes.ECB, "\0\0\0\0\0\0\0\0", pad=None, padmode=pyDes.PAD_PKCS5)
d = 'zzz3jP2U4ntEB+ECeykj6w=='
d = base64.b64decode(d)
e = k.decrypt(d)
print(e)
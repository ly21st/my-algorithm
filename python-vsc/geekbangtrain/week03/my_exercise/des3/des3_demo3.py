# -*- coding: utf-8 -*-

import Crypto.Cipher.DES3
import base64
import binascii
def auto_fill(x):
  if len(x) > 24:
    raise "密钥长度不能大于等于24位！"
  else:
    while len(x) < 16:
      x += " "
    return x.encode()
key = "asd1230123456789"
content = "abcdefg1234567"
x = Crypto.Cipher.DES3.new(auto_fill(key), Crypto.Cipher.DES3.MODE_ECB)
a = base64.encodebytes(x.encrypt(auto_fill(content)))
print(a)
b = x.decrypt(base64.decodebytes(a))
print(b)
print("")


a = binascii.b2a_base64(x.encrypt(auto_fill(content)))
b = x.decrypt(binascii.a2b_base64(a))
print(a)
print(b)
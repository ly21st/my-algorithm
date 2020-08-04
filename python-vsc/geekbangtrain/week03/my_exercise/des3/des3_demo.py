# -*- coding: utf-8 -*-

from Crypto.Cipher import DES3
import base64

class Prpcrypt():
    def __init__(self):
        self.mode = DES3.MODE_ECB # 加密模式
        self.BS = DES3.block_size

    def pad(self,s):
        bw = self.BS - len(s) % self.BS
        if bw!=8:
            # 每8位一组，不足8位需要补位。
            return s + (self.BS - len(s) % self.BS) * chr(self.BS - len(s) % self.BS)
        else:
            return s

    def unpad(self,s):
        bw = self.BS - len(s) % self.BS
        if bw !=8:
            return s[0:-ord(s[-1])]
        return s

    def encrypt(self, text,key):
        # 加密
        text = self.pad(text)

        cryptor = DES3.new(key, self.mode)
        x = len(text) % 8
        if x != 0:
            text = text + '\0' * (8 - x)
        # print(text)
        self.ciphertext = cryptor.encrypt(text)
        return base64.standard_b64encode(self.ciphertext).decode("utf-8")

    def decrypt(self, text,key):
        # 解密
        cryptor = DES3.new(key, self.mode)
        de_text = base64.standard_b64decode(text)
        plain_text = cryptor.decrypt(de_text)
        st = str(plain_text.decode("utf-8")).rstrip('\0')
        out = self.unpad(st)
        return out


prpcrypt = Prpcrypt()

encrypt_text = prpcrypt.encrypt('hello', '1234567890123456')
print('encrypt_text:', encrypt_text)

decrypt_text = prpcrypt.decrypt(encrypt_text, '1234567890123456')
print('decrypt_text:', decrypt_text)
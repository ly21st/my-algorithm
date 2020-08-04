import pyDes

data = "Please encrypt my data"
k = pyDes.des("DESCRYPT", pyDes.CBC, "\0\0\0\0\0\0\0\0", pad=None, padmode=pyDes.PAD_PKCS5)
d = k.encrypt(data)
print("Encrypted: %r" % d)
print("Decrypted: %r" % k.decrypt(d))
assert("after decrypted:", k.decrypt(d))
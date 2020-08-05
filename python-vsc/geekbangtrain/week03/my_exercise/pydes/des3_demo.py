import pyDes
import base64

data = "Please encrypt my data"
k = pyDes.des("DESCRYPT", pyDes.CBC, "\0\0\0\0\0\0\0\0", pad=None, padmode=pyDes.PAD_PKCS5)
d = k.encrypt(data)
print("Encrypted: %r" % d)

print("Decrypted: %r" % k.decrypt(d))
print('type(k.decrypt(d)):', type(k.decrypt(d)))
print("after decrypted:", k.decrypt(d))
print('')


aa = base64.encodebytes(d)
print('type(aa)', type(aa))
print('aa:', aa)
aa_str =  aa.decode("utf-8")
print('aa.decode:', aa_str)
print('')

print("Decrypted: %r" % k.decrypt(base64.decodebytes(aa)))
print("Decrypted2: %r" % k.decrypt(base64.decodebytes(aa_str.encode('utf-8'))))
print("after decrypted:", k.decrypt(d))
print('')



bb = base64.standard_b64encode(d)
print('type(bb):', type(bb))
print('bb:', bb)
print('bb.decode:', bb.decode("utf-8"))
print('')

print("Decrypted3: %r" % k.decrypt(base64.standard_b64decode(bb)))
print("Decrypted4: %r" % k.decrypt(base64.standard_b64decode(bb.decode("utf-8").encode('utf-8'))))
print("after decrypted:", k.decrypt(d))
print('')

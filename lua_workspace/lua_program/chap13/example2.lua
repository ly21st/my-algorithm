s = string.pack(">i4", 1000000)
for i = 1, #s do print((string.unpack("B", s, i))) end

print('-----------------------------')
s = string.pack("<i2 i2", 500, 24)
for i = 1, #s do print((string.unpack("B", s, i))) end
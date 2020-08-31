s = "hello\0Lua\0world\0"
local i = 1
while i <= #s do
    local res
    res, i = string.unpack("z", s, i)
    print(res, i)
end

print('-------------')
s = "\xFF"
print(string.unpack("b", s))
print(string.unpack("B", s))
print('--------------------')

s = string.pack("s1", "hello")
local i = 1
local res
local j = 1
for i = 1, #s do
    res, j = string.unpack("B", s, i)
    print(res, j)
end
print('-------------------------')

s = string.pack("c5", "hello")
local i = 1
local res
local j = 1
for i = 1, #s do
    res, j = string.unpack("B", s, i)
    print(res, j)
end
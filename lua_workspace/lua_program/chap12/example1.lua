print(os.time())

t = os.date("*t", 906000490)
for k, v in pairs(t) do
    print(k, v)
end
print('--------------')

t = os.date("*t", os.time())
for k, v in pairs(t) do
    print(k, v)
end

print('----------------')
print(os.date("a %A in %B"))
print(os.date("%d/%m/%Y", 906000490))

t = 906000490
print(os.date("%Y-%m-%d", t))
print(os.date("%Y-%m-%dT%H:%M:%S", t))
print(os.date("%Y-%j", t))

print('--------------')
print(os.date("!%c", 0))
print(os.date("%c", 0))
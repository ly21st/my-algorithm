local x = os.clock()
local s = 0
for i = 1, 1000000000 do
    s = s + i
end
print("consum time:%d\n", os.clock() - x)
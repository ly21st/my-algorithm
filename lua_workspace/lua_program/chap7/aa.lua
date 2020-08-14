local f = io.popen("dir /", "r")
print("f:", f)
local dir = {}
for entry in f:lines() do
    dir[#dir + 1] = entry
    print(entry)
end  


function split(s, sep)
    local res = {}
    pattern = string.format("[^%s]+", sep)
    print("pattern:", pattern)
     for word in string.gmatch(s, pattern) do
        res[#res+1] = word or ""
     end
     return res
end



function split2(s, sep)
    local res = {}
    local len = #s
    local i = 1
    local b
    local e
    while true  do
        b, e = string.find(s, sep, i)
        if b == nil then 
            break
        end
        res[#res+1] = string.sub(s, i, b - 1)
        i = e + 1
    end
    if i <= len then 
        res[#res+1] = string.sub(s, i, len)
    end
    return res
end



-- r = split("a whole new world", " ")
-- r = split("", " ")
-- r = split("hello", " ")
-- r = split(",a whole new world", ",")
r = split2(",", ",")
for k, v in pairs(r) do
    print(k, v)
end

-- print(string.find("hell world", ","))


-- r = split2("a whole new world", " ")
r = split2(",", ",")
print('--------')
for k, v in pairs(r) do
    print(k, v)
end

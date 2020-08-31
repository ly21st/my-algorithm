local Set = {}
local mt = {}

function Set.new(l)
    local set = {}
    setmetatable(set, mt)
    for _, v in ipairs(l) do set[v] = true end
    return set
end



function Set.intersection(a, b)
    local res = Set.new{}
    for k in pairs(a) do
        res[k] = b[k]
    end
    return res
end


function Set.union(a, b)
    print("in Set.union")
    local res = Set.new{}
    print("in a:")
    for k in pairs(a) do
        print(k)
        res[k] = true
    end
    print("in b:")
    for k in pairs(b) do
        print(k)
        res[k] = true
    end
    print("--------")
    return res
end


function Set.tostring(set)
    local l = {}
    for k in pairs(set) do
        l[#l + 1] = tostring(k)
    end
    return "{" .. table.concat(l, ",") .. "}"
end

mt.__add = Set.union

s1 = Set.new{10, 20, 30, 50}
s2 = Set.new{30, 1}

print(getmetatable(s1))
print(getmetatable(s2))


s3 = s1 + s2

for k, v in pairs(s3) do
    print(k, v)
end

print('---------')

print(Set.tostring(s3))

return Set
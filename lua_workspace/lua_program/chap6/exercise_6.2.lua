function printArg(...)
    local res = {}
    local i = 1
    for k, v in ipairs({...}) do
        if k ~= 1 then 
            res[i] = v
            i = i + 1
        end
    end
    return table.unpack(res)
end

function printArg2(...)
    return table.unpack({...}, 2, #{...})
end

print(printArg(10,20, 30, 40, 50))

print(printArg2(10,20, 30, 40, 50))
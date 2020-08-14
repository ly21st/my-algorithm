function printArg(arr)
    print(table.unpack(arr))
end


function printArg2(arr)
    for _, v in ipairs(arr) do
        print(v)
    end
end


print(printArg({10,20,30}))

print(printArg2({10,20,30}))


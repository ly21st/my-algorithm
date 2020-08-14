function printArg(...)
    return table.unpack({...}, 1, #{...} - 1)
end

print(printArg(10, 20, 30, 40, 50))
function add(...)
    local sum = 0
    for i, v in ipairs{...} do 
        sum = sum + v
    end
    return sum
end


print(add(1,2,3,4,5))
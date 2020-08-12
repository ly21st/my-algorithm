function calSum(t, x)
    local sum = 0
    local n = #t
    local y = 1
    for i = 1, n do
        sum = sum + t[i] * y
        y = y * x
    end
    return sum
end


print(calSum({1,2,3}, 2))
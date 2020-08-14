function ispali(str)
    n = #str
    local i = 1
    local j = n
    while i < j 
    do  
        c1 = string.sub(str, i, i)
        c2 = string.sub(str, j, j)
        if c1 ~= c2 then
            return false
        end
        i = i + 1
        j = j - 1
    end
    return true
end

print(ispali("step on no pets"))
print(ispali("baana"))
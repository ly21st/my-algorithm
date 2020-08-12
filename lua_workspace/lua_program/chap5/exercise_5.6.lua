function checkSequence(t)
    local i = 0
    for k, v in pairs(t) do
        i = i + 1
        if i ~= k then
            return false
        end
    end
    return true
end

a = {10, 20, 30, 40}
b = {10, 20, 30, a = "hello", 40}
c = {10, 20, 30, nil, 40}

print(checkSequence(a))
print(checkSequence(b))
print(checkSequence(c))

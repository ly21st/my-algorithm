function insert(src, offset, str)
    preStr = string.sub(src, 1, offset - 1)
    return preStr .. str .. string.sub(src, offset, -1)
end

print(insert("hello world", 1, "start: "))
print(insert("hello world", 7, "small "))


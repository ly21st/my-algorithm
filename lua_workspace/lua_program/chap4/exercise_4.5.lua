function remove(src, offset, len)
    preStr = string.sub(src, 0, offset - 1)
    affterFix = string.sub(src, offset + len, -1)
    return preStr .. affterFix
end

print(remove("hello world", 7, 4))
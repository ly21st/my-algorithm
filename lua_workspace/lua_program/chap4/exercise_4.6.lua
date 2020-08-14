function remove(src, offset, len)
    byteOffset = utf8.offset(src, offset)
    afterOffset = utf8.offset(src, offset + len)
    preStr = string.sub(src, 0, byteOffset - 1)
    affterFix = string.sub(src, afterOffset, -1)
    return preStr .. affterFix
end

print(remove("r茅sum茅", 2, 2))
function insert(src, offset, str)
    byteOffset = utf8.offset(src, offset)
    preStr = string.sub(src, 1, byteOffset - 1)
    return preStr .. str .. string.sub(src, byteOffset, -1)
end

print(insert("r茅sum茅", 7, "!"))
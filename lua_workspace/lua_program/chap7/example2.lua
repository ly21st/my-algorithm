function fsize(file)
    local current = file:seek("cur")
    local size = file:seek("end")
    file:seek("set", current)
    return size
end

file = io.open("example1.lua", "r")
print("file:", file)
print(fsize(file))
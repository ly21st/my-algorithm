print(io.open("non-exitent-file", "r"))
print(io.open("/etc/passwd", "w"))

-- local f = assert(io.open("/etc/passwd", "w"))

for block in io.input():lines(2^13) do 
    io.write(block)
end


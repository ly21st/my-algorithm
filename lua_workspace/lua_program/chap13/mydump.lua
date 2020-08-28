function mydump(fileName)
    local fp = io.open(fileName, "rb")
    local blockSize = 16

    for bytes in fp:lines(blockSize) do
        for i = 1, #bytes do
            local c, _ = string.unpack("B", bytes, i)
            io.write(string.format("%02x ", c))
        end
        local rep = string.rep("   ", blockSize - #bytes)
        io.write(rep)

        bytes = string.gsub(bytes, "%c", ".")
        -- io.write(string.format(" %s\n", bytes))
        io.write(" ", bytes, "\n")
    end
end

mydump("mydump.lua")
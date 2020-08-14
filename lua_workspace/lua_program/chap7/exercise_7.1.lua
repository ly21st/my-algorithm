function sortAndCopy(inFile, outFile)
    print("inFile:", inFile)
    if inFile ~= nil  then
        inf = io.open(inFile, "r+")
        io.input(inf)
    end
    print("outFile:", outFile)
    if outFile ~= nil then 
        outf = io.open(outFile, "w+") 
        io.output(outf)
    end
    
    t = io.read("a")
    -- print("t:", t)
    print("----------------------------")
    io.write(t)
    io.flush()
    io.close()
end

-- sortAndCopy()

-- sortAndCopy("E:\\liyuan-github\\my-algorithm\\lua_workspace\\lua_program\\chap7\\example3.lua")

sortAndCopy("E:\\liyuan-github\\my-algorithm\\lua_workspace\\lua_program\\chap7\\example3.lua", "aa.lua")
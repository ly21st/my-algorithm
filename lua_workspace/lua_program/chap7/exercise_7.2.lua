function sortAndCopy(inFile, outFile)
    print("inFile:", inFile)
    local inf
    local outf
    local t

    if inFile ~= nil  then
        inf = io.open(inFile, "r+")
    end

    print("outFile:", outFile)
    if outFile ~= nil then 
        outFileR = io.open(outFile, "r")
        print('outFileR:', outFileR)
        if outFileR ~= nil then 
            print("are you to overwrite outfile? please type:")
            local answer = io.read()
            if answer ~= "y" then 
                print("exit.")
                os.exit(-1)
            end
            print("continue.")
        end
        outf = io.open(outFile, "w+") 
    end
    
    if inf ~= nil then 
        t = inf:read("a")
        inf:close()
    else
        t = io.read("a")
    end

    if outf ~= nil then 
        outf:write(t)
        outf:flush()
        outf:close()
    else
        io.write(t)
        io.flush()
    end

    print("----------------------------")
end

-- sortAndCopy()

-- sortAndCopy("E:\\liyuan-github\\my-algorithm\\lua_workspace\\lua_program\\chap7\\example3.lua")

sortAndCopy("E:\\liyuan-github\\my-algorithm\\lua_workspace\\lua_program\\chap7\\example3.lua", "aa.lua")
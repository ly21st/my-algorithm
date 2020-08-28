function serizlize(o)
    local t = type(o)
    if t == "number" or t == "string" or t == "boolean" or t == nil then 
        io.write(string.format("%q", o))
    elseif t == "table" then 
        io.write("{\n")
        for k, v in pairs(o) do
            io.write("  ", k, " = ")
            serizlize(v)
            io.write(",\n")
        end
        io.write("}\n")
    else
        error("cannot serialize a " .. type(o))
    end
end

serizlize{a=12,b='lua', key='another "one"', c={name='lilei', age=30}}
function concat(t) 
    local s = ""
    for _, v in pairs(t) do
        s = s .. v
    end
    return s
end

print(concat({"hello", " ", "world"}))


-- function concat2(t) 
--     local s = ""
--     for _, v in pairs(t) do
--         s = string.concat(s, v)
--     end
--     return s
-- end



-- print(concat2({"hello", " ", "world"}))
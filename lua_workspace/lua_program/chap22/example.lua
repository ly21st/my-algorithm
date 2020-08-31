setmetatable(_G,{
    __newindex = function(t, n)
        print("t:", t)
        error("attempt to write to undeclared variable " .. n, 2)
    end,
    __index = function(t, n)
        print("t:", t)
        error("attempt to read undeclared variable " .. n, 2)
    end,
})


print("_G:", _G)
print(a)

function declare(name, initval)
    rawset(_G, name, initval or false)
end
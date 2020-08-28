print "enter you expression:"
local line = io.read()
-- local func = assert(load("return " .. line))
local func = assert(load("print(line)" .. "; return " .. line))
print("the value of your express is " .. func())
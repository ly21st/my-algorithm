pair = "name = Anna"

key, val = string.match(pair, "%s*(%a+)%s*=%s*(%a+)%s*")
print("key:val", key, val)



date = "Today is 17/7/1990"
d, mon, year = string.match(date, "(%d+)/(%d+)/(%d+)")
print(d, mon, year)


s = [[then he said: "it's all right"!]]

-- q, quotedPart = string.match(s, "([\"'])(.*)(%1)")
q, quotedPart = string.match(s, "([\"'])(.*)%1")
print(quotedPart)    


p = "%[(=*)%[(.-)%]%1%]"
s =" a = [=[[[ something ]] ]==] ]=] ; print(a )"
print(string.match(s, p))


function trim(s)
    newS = string.match(s, "^%s*(.-)%s*$")
    return newS
end

function trim2(s)
    s = string.gsub(s, "^%s*(.-)%s*$", "%1")
    return s
end


a = " hello world     "
print(trim(a))
print(trim2(a))
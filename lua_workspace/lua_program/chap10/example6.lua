function unescape(s)
    s = string.gsub(s, "+", " ")
    s = string.gsub(s, "%%(%x%x)", function(x) 
        local num = tonumber(x, 16)
        return string.char(num)
        end)
        return s
end


print(unescape("a%2Bb+%3D+c"))

           


cgi = {}
function decode(s)
    for name, value in string.gmatch(s, "([^&=]+)=([^&=]+)") do
        name = unescape(name)
        value = unescape(value)
        cgi[name] = value
    end
end


function escape2(s)
    s = string.gsub(s, "[^%w%s]", function(x)
            x = string.byte(x)
            x = string.format("%%%02X", x)
            return x
        end)
    s = string.gsub(s, " ", "+")
    return s
end



function escape(s)
    s = string.gsub(s, "[&=+%%%c]", function(x)
            x = string.byte(x)
            x = string.format("%%%02X", x)
            return x
        end)
    s = string.gsub(s, " ", "+")
    return s
end


print(escape("a+b = c"))


function encode(t)
    local b = {}
    for k, v in pairs(t) do
        k = escape(k)
        v = escape(v)
        b[#b+1] = (k .. "=" .. v)
    end
    return table.concat(b, '&')
end

t = {name = "al", query = "a+b = c", q = "yes or no"}
print(encode(t))
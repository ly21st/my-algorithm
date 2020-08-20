s = [[follows a typical string: "This is \"great\"!".]]
print(s)
function code(s)
    s = string.gsub(s, "\\(.)", function(x)
            -- s = string.format("\\%03d", tonumber(string.byte(x)))
            s = string.format("\\%03d", string.byte(x))
            return s
        end)
    return s
end


function decode(s)
    s = string.gsub(s, "\\(%d%d%d)", function(x)
        return "\\" .. string.char(tonumber(x))
    end)
    return s
end

print(code(s))
s = code(s)
s = string.gsub(s, '".-"', string.upper)
print(s)

print(decode(s))
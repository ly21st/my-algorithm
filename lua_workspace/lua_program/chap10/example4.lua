function expand(s)
    return (string.gsub(s, "$(%w+)", _G))
end

name = "Lua"; status = "great"
print(expand("$name is $status, isn't it?"))


function expand2(s)
    return (string.gsub(s, "$(%w+)", function(n)
        return tostring(_G[n])
    end))
end


print(expand2("print = $print; a = $a"))
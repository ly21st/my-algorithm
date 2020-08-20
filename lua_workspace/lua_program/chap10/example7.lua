function expandTabs(s, tab)
    tab = tab or 8
    local corr = 0
    s = string.gsub(s, "()\t", function(p)
            print("p:", p)
            local sp = tab - (p - 1 + corr) % tab
            print("sp:", sp)
            corr = corr - 1 + sp
            print("corr:", corr)
            return string.rep(" ", sp)
        end)
    return s
end


print(expandTabs("aaa\tbbb\tcccc\tdddd"))


function unexpandTabs(s, tab)
    tab = tab or 8
    s = expandTabs(s, tab)
    local pat = string.rep('.', tab)
    s = string.gsub(s, pat, "%0\1")
    s = string.gsub(s, " +\1", "\t")
    s = string.gsub(s, "\1", "")
    return s
end
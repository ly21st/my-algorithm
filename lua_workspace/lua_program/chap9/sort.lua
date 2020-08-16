network = {
    {name = "grauna", ip = "210.26.30.34"},
    {name = "arraial", ip = "210.26.30.34"},
    {name = "lua", ip = "210.26.30.34"},
    {name = "derain", ip = "210.26.30.34"}
}

for k, v in pairs(network) do
    print(k, v.name)
end
print('-----------')

table.sort(network, function(a, b) return a.
    name > b.name end)

for k, v in pairs(network) do
    print(k, v.name)
end


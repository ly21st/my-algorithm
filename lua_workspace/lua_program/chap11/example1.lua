function compuat_word_count(filename)
    -- 读取文件
    local file = io.open(filename, "r+")
    local content = file:read("*a")

    local words = {}
    local word_count = {}
    for word in string.gmatch(content, "%a+") do
        word_count[word] = (word_count[word] or 0) + 1
    end

    for key, val in pairs(word_count) do
        words[#words + 1] = key
        print(key, val)
    end
    print('-----------')

    table.sort(words, function(a,b)
        return (word_count[a] > word_count[b])
    end)

    for key, val in ipairs(words) do
        print(key, val)
    end
end

compuat_word_count("example1.lua")

function helper(row, n)
    if row > n then
        for i = 1, n do
            local s = ""
            for j = 1, n do
                if output[i][j] == 1 then
                    s = s .. 'X '
                else 
                    s = s .. '. '
                end
            end   
            print(s) 
        end
        print("")
    end

    for j = 1, n do
        if cols[j] == nil and slash[row+j] == nil and rslash[n-1+row-j] == nil then 
            output[row][j] = 1
            cols[j] = 1
            slash[row+j] = 1
            rslash[n-1+row-j] = 1
            helper(row+1, n)
            output[row][j] = nil
            cols[j] = nil
            slash[row+j] = nil
            rslash[n-1+row-j] = nil
        end
    end
end

cols = {}
slash = {}
rslash = {}
output = {}

function queen(n)
    for i = 1, n do
        output[i] = {}
    end
    helper(1, n)
end


queen(4)
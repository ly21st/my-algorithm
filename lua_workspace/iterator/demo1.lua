function test1()
    local array = {"Google", "Runoob"}
    for key, value in ipairs(array)
    do
        print(key, value)
    end
end

function square(iteratorMaxCount, currentNumber)
    if currentNumber < iteratorMaxCount
    then
        currentNumber = currentNumber + 1
        return currentNumber, currentNumber * currentNumber
    end
end

function test2()
    for i, n in square, 3, 0
    do
        print(i, n)
    end
end


-- function iter(a, i)
--     local len = #a
--     if i < len 
--     then 
--         i = i + 1
--         return i, a[i]
--     end
-- end

function iter(a, i)
    i = i + 1
    local v = a[i]
    if v
    then
        return i, v 
    end
end

function my_ipair(a)
    return iter, a, 0
end


function test3() 
    arr1 = {"hello", "world", "good", "idea"}
    for i, v in my_ipair(arr1)
    do
        print(i, v)
    end    
end


array = {"googld", "Runoob"}

function elementIterator(collection)
    local index = 0
    local count = #collection
    return function() 
        index = index + 1
        if index <= count
        then 
            return collection[index]
        end
    end
end


function test4()
    for element in elementIterator(array)
    do
        print(element)
    end
end

-- test1()
-- test2()
-- test3()
test4()
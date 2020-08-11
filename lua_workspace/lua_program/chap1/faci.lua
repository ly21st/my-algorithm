function faci(n)
    if n == 0 then
        return 1
    end
    if n == 1 then
        return 1
    end
    return faci(n - 2) + faci(n - 1)
end


print("enter a number:")
n = io.read("*n")
print(faci(n))
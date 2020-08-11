function fact_posi(n)
    if n == 0 then
        return 1
    end
    return n * fact_posi(n - 1)
end

function fact_neg(n) 
    if n == 0 then
        return 1
    end
    return n * fact_neg(n + 1)
end

function fact(n) 
    if n >= 0 then 
        return fact_posi(n)
    else 
        return fact_neg(n)
    end
end

print(fact(6))
print(fact(-6))
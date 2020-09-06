co =coroutine.create(function(a, b)
    coroutine.yield(a+b, a-b)
end)

print(coroutine.resume(co, 20, 10))
print(coroutine.resume(co))
print(coroutine.resume(co))

print("----------------------")
co = coroutine.create(function() 
    return 6, 7
end)

print(coroutine.resume(co))
print(coroutine.resume(co))
co = coroutine.create(function () print("hi") end)
print(type(co))

print(coroutine.status(co))
print(coroutine.resume(co))
print(coroutine.status(co))


co = coroutine.create(function() 
    for i = 1, 5 do
        print("co", i)
    coroutine.yield()
    end
end)

print(coroutine.resume(co))
print(coroutine.resume(co))
print(coroutine.resume(co))
print(coroutine.resume(co))
print(coroutine.resume(co))
print(coroutine.resume(co))
print(coroutine.resume(co))
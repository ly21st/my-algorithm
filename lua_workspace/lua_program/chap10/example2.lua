print((string.gsub("one, and two; and three", "%a+", "world")))

print(string.match("the number 1298 is even", "%d+"))


test = "int x; /* x */  int y;  /*  y  */"
print((string.gsub(test, "/%*.*%*/", "")))


print((string.gsub(test, "/%*.-%*/", "")))

s = "a (enclosed (in) parentheses) line"
print((string.gsub(s, "%b()", "")))
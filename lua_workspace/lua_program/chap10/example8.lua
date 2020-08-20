i, j = string.find(";$%   **#$hello13", "%a*")
print(i, j)
print(string.find(";$%   **#$hello13", "%a+"))


pattern = string.rep("[^\n]", 70) .. "+"
print(pattern)
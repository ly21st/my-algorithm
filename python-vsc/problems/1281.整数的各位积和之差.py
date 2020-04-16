#
# @lc app=leetcode.cn id=1281 lang=python3
#
# [1281] 整数的各位积和之差
#

# @lc code=start
class Solution:
    def subtractProductAndSum(self, n: int) -> int:
        add, mul = 0, 1
        while n > 0:
            digit = n % 10
            n //= 10
            add += digit
            mul *= digit
        return mul - add

# @lc code=end





# class Solution:
#     def subtractProductAndSum(self, n: int) -> int:
#         product = 1
#         sum = 0
#         while n != 0:
#             t = int(n % 10)
#             product *= t
#             sum += t
#             n = int(n / 10)
#         return product - sum




# class Solution:
#     def subtractProductAndSum(self, n: int) -> int:
#         tem=1
#         sum=0
#         for i in str (n):
#             tem*=int (i)
#             sum+=int(i)
#         return tem-sum

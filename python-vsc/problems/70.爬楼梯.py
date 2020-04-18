#
# @lc app=leetcode.cn id=70 lang=python3
#
# [70] 爬楼梯
#

# @lc code=start
class Solution:
    def climbStairs(self, n: int) -> int:
        return self.climbStairsStep(0, n)

    def climbStairsStep(self, i: int, n: int) ->int:
        if i > n:
            return 0
        if i == n:
            return 1
        return self.climbStairsStep(i+1, n) + self.climbStairsStep(i+2, n)

        
# @lc code=end


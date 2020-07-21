#

#
# @lc app=leetcode.cn id=11 lang=python3
#
# [11] 盛最多水的容器
#



# @lc code=start

class Solution:
    def maxArea(self, height: List[int]) -> int:
        height_len = len(height)
        i = 0
        j = height_len - 1
        max_value = min(height[i], height[j]) * (j - i)
        while i < j:
            if height[i] < height[j]:
                i += 1
                max_value = max(max_value, min(height[i], height[j]) * (j - i))
            else:
                j -= 1
                max_value = max(max_value, min(height[i], height[j]) * (j - i))
        return max_value







# @lc code=end



# class Solution:
#     def maxArea(self, height: List[int]) -> int:
#         height_len = len(height)
#         max_value = 0
#         for i in range(0, height_len-1):
#             for j in range(i+1, height_len):
#                 max_value =max(max_value, min(height[i], height[j]) * (j - i))
#         return max_value
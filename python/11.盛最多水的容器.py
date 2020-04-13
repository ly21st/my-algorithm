# @before-stub-for-debug-begin
from python3problem11 import *
from typing import *
# @before-stub-for-debug-end

#
# @lc app=leetcode.cn id=11 lang=python3
#
# [11] 盛最多水的容器
#

# @lc code=start
class Solution:
    def maxArea(self, height: List[int]) -> int:
        height_len = len(height)
        if height_len < 2:
            return 0
        i = 0
        j = height_len - 1
        max_area = min(height[i], height[j]) * (j - i)
        while i < j:
            tmp = height[i]
            i += 1
            while i < j:
                if height[i] > tmp:
                    break
                i += 1
            if i >= j:
                break
            tmp = height[j]
            j -= 1
            while i < j:
                if height[j] > tmp:
                    break
                j -= 1
            if i >= j:
                break
            max_area = max(max_area, min(height[i], height[j])*(j - i))
        return max_area




# @lc code=end


# class Solution:
#     def maxArea(self, height: List[int]) -> int:
#         height_len = len(height)
#         if height_len < 2:
#             return 0
#         i = 0
#         j = height_len - 1
#         max_area = min(height[i], height[j]) * (j - i)
#         while i < j:
#             if height[i] < height[j]:
#                 i += 1
#                 max_area = max(max_area, min(height[i], height[j])*(j - i))
#             else:
#                 j -= 1
#                 max_area = max(max_area, min(height[i], height[j])*(j - i))
#         return max_area

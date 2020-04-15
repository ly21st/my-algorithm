#
# @lc app=leetcode.cn id=189 lang=python3
#
# [189] 旋转数组
#

# @lc code=start
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if not nums:
            return 
        nums_len = len(nums)
        if nums_len < 2:
            return 
        k = k % nums_len
        if not k:
            return 

        self.rotate_aux(nums, 0, nums_len - k, nums_len)



    def _gcd(self, m: int, n: int):
        while m != 0:
            t = n % m
            n = m 
            m = t
        return n

# @lc code=end






# class Solution:
#     def rotate(self, nums: List[int], k: int) -> None:
#         """
#         Do not return anything, modify nums in-place instead.
#         """
#         if not nums:
#             return 
#         nums_len = len(nums)
#         if nums_len < 2:
#             return 
#         k = k % nums_len
#         if not k:
#             return 
#         self.reserve(nums, 0, nums_len - k)
#         self.reserve(nums, nums_len - k, nums_len)
#         self.reserve(nums, 0, nums_len)

#     def reserve(self, nums: List[int], first: int, end: int):
#         last = end - 1
#         while first < last:
#             nums[first], nums[last] = nums[last], nums[first]
#             first += 1
#             last -= 1





# class Solution:
#     def rotate(self, nums: List[int], k: int) -> None:
#         """
#         Do not return anything, modify nums in-place instead.
#         """
#         if not nums:
#             return 
#         nums_len = len(nums)
#         if nums_len < 2:
#             return 
#         k = k % nums_len
#         if not k:
#             return 

#         i, j = 0, nums_len - k
#         middle = nums_len - k
#         while True:
#             while i < middle and j < nums_len:
#                 nums[i], nums[j] = nums[j], nums[i]
#                 i += 1
#                 j += 1
#             if i == middle:
#                 if j == nums_len:
#                     return
#                 middle = j
#             else:
#                 j = middle




# class Solution:
#     def rotate(self, nums: List[int], k: int) -> None:
#         """
#         Do not return anything, modify nums in-place instead.
#         """
#         if not nums:
#             return 
#         nums_len = len(nums)
#         if nums_len < 2:
#             return 
#         k = k % nums_len
#         if not k:
#             return 

#         self.rotate_aux(nums, 0, nums_len - k, nums_len)

#     def rotate_aux(self, nums: List[int], first: int, middle: int, last: int):
#         if last - first <= 1:
#             return
#         i, j = first, middle;
#         while i < middle and j < last:
#                 nums[i], nums[j] = nums[j], nums[i]
#                 i += 1
#                 j += 1
#         if i == middle:
#             if j == last:
#                 return
#             self.rotate_aux(nums, i, j, last)
#         else:
#             self.rotate_aux(nums, i, middle, last)

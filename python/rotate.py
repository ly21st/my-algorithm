# -*- coding:utf-8 -*-

# class Solution:
#     def rotate(self, nums: List[int], k: int) -> None:
#         """
#         Do not return anything, modify nums in-place instead.
#         """
#

class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        length = len(nums)
        if length <= 1:
            return
        k = k % length
        if k != 0:
            self.reverse(nums, 0 , length-k)
            self.reverse(nums, length-k, length)
            self.reverse(nums, 0, length)

    @staticmethod
    def reverse(nums, i, j):
        j = j - 1
        while i < j:
            nums[i], nums[j] = nums[j], nums[i]
            i = i + 1
            j = j - 1

if __name__ == "__main__":
    nums = [1, 2, 3, 4, 5, 6, 7]
    print(nums)
    s = Solution()
    s.rotate(nums, 3)
    print(nums)
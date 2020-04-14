#! -*- coding: utf-8 -*-

class Solution(object):
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: None Do not return anything, modify nums1 in-place instead.
        """
        if n == 0: return
        if m == 0: nums1[:] = nums2[:]
        nums = [None] * (m + n)
        i = 0
        j = 0
        cur = 0
        while i < m and j < n:
            if nums1[i] <= nums2[j]:
                nums[cur] = nums1[i]
                cur += 1
                i += 1
            else:
                nums[cur] = nums2[j]
                cur += 1
                j += 1
        nums[cur:] = nums1[i:m] or nums2[j:n]
        nums1[0:] = nums
        return nums



if __name__ == '__main__':
    s = Solution()
    nums1 = [1, 2, 3, 0, 0, 0]
    nums2 = [2, 5, 6]

    nums = s.merge(nums1, 3, nums2, 3)
    print(nums1)
    print(nums)

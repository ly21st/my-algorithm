import java.util.Map;

/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 *
 * https://leetcode-cn.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (65.58%)
 * Likes:    867
 * Dislikes: 0
 * Total Accepted:    262.9K
 * Total Submissions: 400.8K
 * Testcase Example:  '[3,2,3]'
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：[3,2,3]
 * 输出：3
 * 
 * 示例 2：
 * 
 * 
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * 
 * 
 * 
 * 
 * 进阶：
 * 
 * 
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        return helper(nums);
    }

    public int helper(int []nums) {
        int len = nums.length;
        if (len < 1) {
            return -1;
        }
        int count = 0;
        int val = nums[0];
        for (int i = 0; i < len; i++) {
            if (nums[i] == val) {
                count++;
                continue;
            } 
            if (count == 0) {
                val = nums[i];
                count++;
            } else {
                count--;
            }
        }
        return val;
    }
}
// @lc code=end


// 计数法
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> refCnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int v = refCnt.getOrDefault(nums[i], 0);
            if (v >= n / 2) {
                return nums[i];
            }
            refCnt.put(nums[i], v + 1);
        }
        return -1;
    }
}


// 排序法
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return nums[n / 2];
    }
}



// 二分法
class Solution {
    public int majorityElement(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    public int binarySearch(int []nums, int low, int hight) {
        if (low == hight) {
            return nums[low];
        }
        int mid;
        mid = (hight - low) / 2 + low;
        int left = binarySearch(nums, low, mid);
        int right = binarySearch(nums, mid + 1, hight);
        if (left == right) {
            return left;
        }
        int leftCnt = rangeCount(nums, left, low, mid);
        int rightCnt = rangeCount(nums, right, mid + 1, hight);
        return leftCnt > rightCnt ? left : right;
    }

    public int rangeCount(int []nums, int m, int low, int hight) {
        int count = 0;
        for (int i = low; i <= hight; i++) {
            if (nums[i] == m) {
                count++;
            }
        }
        return count;
    }
}
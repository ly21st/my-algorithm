/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 *
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (40.47%)
 * Likes:    1181
 * Dislikes: 0
 * Total Accepted:    220K
 * Total Submissions: 543.5K
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * 升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2]
 * ）。
 * 
 * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [1], target = 0
 * 输出：-1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * -10^4 
 * nums 中的每个值都 独一无二
 * nums 肯定会在某个点上旋转
 * -10^4 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len < 1) {
            return -1;
        }
        return binarySearch(nums, target, 0, len - 1);
    }

    public int binarySearch(int []nums, int target, int low, int hight) {
        if (hight < low) {
            return -1;
        }
        int mid = low + (hight - low) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[low] == target) {
            return low;
        }
        if (nums[hight] == target) {
            return hight;
        }
        if (nums[low] < nums[mid]) {
            if (nums[low] <= target && target < nums[mid]) {
                return binarySearch(nums, target, low, mid - 1);
            } else {
                return binarySearch(nums, target, mid + 1, hight);
            }
        } else {
            if (nums[mid] < target && target < nums[hight]) {
                return binarySearch(nums, target, mid + 1, hight);
            } else {
                return binarySearch(nums, target, low, mid - 1);
            }   
        }
    }
}
// @lc code=end


// 迭代解法
class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len < 1) {
            return -1;
        }
        return binarySearch(nums, target);
    }

    public int binarySearch(int []nums, int target) {
        int low = 0;
        int hight = nums.length - 1;
        int mid;

        while (low <= hight) {
            mid = low + (hight - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[low] == target) {
                return low;
            }
            if (nums[hight] == target) {
                return hight;
            }
            // 左半边有序
            if (nums[low] < nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    hight = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[hight]) {
                    low = mid + 1;
                } else {
                    hight = mid - 1;
                }
            }
        }
        return -1;
    }
}

//  递归解法
class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len < 1) {
            return -1;
        }
        return binarySearch(nums, target, 0, len - 1);
    }

    public int binarySearch(int []nums, int target, int low, int hight) {
        if (hight < low) {
            return -1;
        }
        int mid = low + (hight - low) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[low] == target) {
            return low;
        }
        if (nums[hight] == target) {
            return hight;
        }
        if (nums[low] < nums[mid]) {
            if (nums[low] <= target && target < nums[mid]) {
                return binarySearch(nums, target, low, mid - 1);
            } else {
                return binarySearch(nums, target, mid + 1, hight);
            }
        } else {
            if (nums[mid] < target && target < nums[hight]) {
                return binarySearch(nums, target, mid + 1, hight);
            } else {
                return binarySearch(nums, target, low, mid - 1);
            }   
        }
    }
}
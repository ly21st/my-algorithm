/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 *
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (52.33%)
 * Likes:    351
 * Dislikes: 0
 * Total Accepted:    103.4K
 * Total Submissions: 197.5K
 * Testcase Example:  '[3,4,5,1,2]'
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7]  可能变为 [4,5,6,7,0,1,2] 。
 * 
 * 请找出其中最小的元素。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [1]
 * 输出：1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * -5000 
 * nums 中的所有整数都是 唯一 的
 * nums 原来是一个升序排序的数组，但在预先未知的某个点上进行了旋转
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        return binarySearch(nums);
    }

    public int binarySearch(int []nums) {
        int low = 0;
        int hight = nums.length - 1;
        int min = nums[0];
        int mid = 0;

        while (low <= hight) {
            mid = low + (hight - low) / 2;
            if (nums[mid] < min) {
                min = nums[mid];
            }
            if (nums[low] < min) {
                min = nums[low];
            } 
            if (nums[hight] < min) {
                min = nums[hight];
            }
            // 左部分升序
            if (nums[low] < nums[mid]) {
                low = mid + 1;
            } else {
                if (nums[mid] < nums[hight]) {
                    hight = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return min;
    }
 }
// @lc code=end


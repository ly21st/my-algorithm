/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 *
 * https://leetcode-cn.com/problems/maximum-product-subarray/description/
 *
 * algorithms
 * Medium (39.66%)
 * Likes:    626
 * Dislikes: 0
 * Total Accepted:    75.6K
 * Total Submissions: 190.3K
 * Testcase Example:  '[2,3,-2,4]'
 *
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * 
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dpMin = new int[n];
        int[] dpMax = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dpMax[i] = nums[i];
                dpMin[i] = nums[i];
                continue;
            }
            int s1 = dpMax[i - 1] * nums[i];
            int s2 = dpMin[i - 1] * nums[i];
            dpMax[i] = Math.max(Math.max(s1, s2), nums[i]);
            dpMin[i] = Math.min(Math.min(s1, s2), nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (max < dpMax[i]) {
                max = dpMax[i];
            }
        }
        return max;
    }
}
// @lc code=end


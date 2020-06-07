import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=217 lang=java
 *
 * [217] 存在重复元素
 *
 * https://leetcode-cn.com/problems/contains-duplicate/description/
 *
 * algorithms
 * Easy (52.40%)
 * Likes:    248
 * Dislikes: 0
 * Total Accepted:    139.4K
 * Total Submissions: 265.7K
 * Testcase Example:  '[1,2,3,1]'
 *
 * 给定一个整数数组，判断是否存在重复元素。
 * 
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3,1]
 * 输出: true
 * 
 * 示例 2:
 * 
 * 输入: [1,2,3,4]
 * 输出: false
 * 
 * 示例 3:
 * 
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 * 
 */

// @lc code=start
class Solution {
    public boolean containsDuplicate(int[] nums) {
       Arrays.sort(nums);
       int len = nums.length;
       for (int i = 0; i < len; i++) {
           if (i > 0 && nums[i] == nums[i - 1]) {
               return true;
           }
       }
       return false;
    }
}
// @lc code=end


// 使用map方法
// class Solution {
//     public boolean containsDuplicate(int[] nums) {
//         Map<Integer, Integer> m = new HashMap<>();
//         for (int n : nums) {
//             int v = m.getOrDefault(n, 0);
//             if (v > 0) return true;
//             m.put(n, 1);
//         }
//         return false;
//     }
// }
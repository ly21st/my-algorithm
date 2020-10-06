/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 *
 * https://leetcode-cn.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (60.39%)
 * Likes:    565
 * Dislikes: 0
 * Total Accepted:    136.3K
 * Total Submissions: 225.2K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 
 * 说明:
 * 
 * 
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * 
 * 
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int i, j;
        for (i = 0, j = 0; j < len; ) {
            if (nums[j] == 0) {
                j++;
                continue;
            }
          
            swap(nums, i, j);
            i++;
            j++;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// @lc code=end



// 解法1
// class Solution {
//     public void moveZeroes(int[] nums) {
//         int len = nums.length;
//         int i, j;
//         for (i = 0, j = 0; j < len; ) {
//             if (nums[j] == 0) {
//                 j++;
//                 continue;
//             }
//             if (i != j) {
//                 nums[i++] = nums[j];
//                 nums[j++] = 0;
//             } else {
//                 nums[i++] = nums[j++];
//             }
//         }
//     }
// }



// 解法2
// class Solution {
//     public void moveZeroes(int[] nums) {
//         int len = nums.length;
//         int i, j;
//         for (i = 0, j = 0; j < len; ) {
//             if (nums[j] == 0) {
//                 j++;
//                 continue;
//             }
//             if (i != j) {
//                 swap(nums, i, j);
//                 i++;
//                 j++;
//             } else {
//                 nums[i++] = nums[j++];
//             }
//         }
//     }

//     public void swap(int[] nums, int i, int j) {
//         int tmp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = tmp;
//     }
// }

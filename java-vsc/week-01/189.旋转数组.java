/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 *
 * https://leetcode-cn.com/problems/rotate-array/description/
 *
 * algorithms
 * Easy (41.05%)
 * Likes:    550
 * Dislikes: 0
 * Total Accepted:    115.9K
 * Total Submissions: 282.1K
 * Testcase Example:  '[1,2,3,4,5,6,7]\n3'
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 
 * 
 * 示例 2:
 * 
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释: 
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 
 * 说明:
 * 
 * 
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * 
 * 
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n < 1) return;
        k = k % n;
        if (k == 0) return;

        int count = 0;
        for (int start = 0; count < n; start++) {
            int current = start;
            int pre = nums[start];
            
            do {
                int next = (current + k) % n;
                int tmp = nums[next];
                nums[next] = pre;
                pre = tmp;
                current = next;
                count++;
            } while (current != start);
        }
    }
}
// @lc code=end


// 有以下方法：
// 1.  暴力法
// 2. 额外数组法
// 3. 环形数组法
// 4. 反转法


// 简洁方法
// class Solution {
//     public void rotate(int[] nums, int k) {
//         int n = nums.length;
//         if (n < 1) return;
//         k = k % n;
//         if (k == 0) return;

//         reverse(nums, n - k, n - 1);
//         reverse(nums, 0, n - k - 1);
//         reverse(nums, 0, n - 1);
//     }

//     public void reverse(int []nums, int i, int j) {
//         int tmp;
//         for (; i <= j; i++, j--) {
//             tmp = nums[i];
//             nums[i] = nums[j];
//             nums[j] = tmp;
//         }
//     }
// }
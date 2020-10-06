import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 *
 * https://leetcode-cn.com/problems/plus-one/description/
 *
 * algorithms
 * Easy (43.80%)
 * Likes:    457
 * Dislikes: 0
 * Total Accepted:    141.5K
 * Total Submissions: 322.7K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * 
 * 
 */

// @lc code=start
//  网友解法
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            int sum = digits[i] + 1;
            digits[i] = sum % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }
}
// @lc code=end




// 本人解法
// class Solution {
//     public int[] plusOne(int[] digits) {
//         int n = digits.length;
//         if (n < 1) return digits;
//         int []res = Arrays.copyOfRange(digits, 0, n);
//         boolean flag = true;
//         for (int i = n - 1; i >= 0; i--) {
//             if (!flag) return res;
//             if (res[i] == 9) {
//                 res[i] = 0;
//                 flag = true;
//             } else {
//                 res[i] = res[i] + 1;
//                 flag = false;
//             }
//         }
//         if (!flag) return res;
//         int []res2 = new int[n + 1];
//         for (int i = 0; i < n; i++) {
//             res2[i + 1] = res[i];
//         }
//         res2[0] = 1;
//         return res2;
//     }
// }
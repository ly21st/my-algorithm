import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 *
 * https://leetcode-cn.com/problems/counting-bits/description/
 *
 * algorithms
 * Medium (75.22%)
 * Likes:    364
 * Dislikes: 0
 * Total Accepted:    48.2K
 * Total Submissions: 63.9K
 * Testcase Example:  '2'
 *
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * 
 * 示例 1:
 * 
 * 输入: 2
 * 输出: [0,1,1]
 * 
 * 示例 2:
 * 
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 
 * 进阶:
 * 
 * 
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 * 
 * 
 */

// @lc code=start
// 动态规划+最低有效位
// p(x) = p(x&(x-1)) + 1
class Solution {
    public int[] countBits(int num) {
        if (num <= 0) {
            return new int[]{0};
        }
        int []output = new int[num+1];
        one_count(num, output);
        return output;
    }

    public void one_count(int num, int []res) {
        for (int i = 1; i <= num; i++) {
            res[i] = res[i&(i-1)] + 1;
        }
    }
}
// @lc code=end


// 笨方法
// class Solution {
//     public int[] countBits(int num) {
//         if (num <= 0) {
//             return new int[]{0};
//         }
//         int []output = new int[num+1];
//         for (int i = 0; i <= num; i++) {
//             output[i] = one_count(i);
//         }
//         return output;
//     }

//     public int one_count(int num) {
//         int count = 0;
//         while (num != 0) {
//             num = num & (num - 1);
//             count++;
//         }
//         return count;
//     }
// }




// 动态规划+最高有效位
// class Solution {
//     public int[] countBits(int num) {
//         if (num <= 0) {
//             return new int[]{0};
//         }
//         int []output = new int[num+1];
//         one_count(num, output);
//         return output;
//     }

//     public void one_count(int num, int []res) {
//         int i = 0; 
//         int k = 1;
//         while (k <= num) {
//             for (i = 0; i < k && i+k <= num; i++) {
//                 res[i + k] = res[i] + 1;
//             }
//             k <<= 1;
//         }
//     }
// }




// 动态规划+最低有效位
// p(x) = p(x/2) + x % 2
// class Solution {
//     public int[] countBits(int num) {
//         if (num <= 0) {
//             return new int[]{0};
//         }
//         int []output = new int[num+1];
//         one_count(num, output);
//         return output;
//     }

//     public void one_count(int num, int []res) {
//         for (int i = 1; i <= num; i++) {
//             res[i] = res[i/2] + (i & 1);
//         }
//     }
// }
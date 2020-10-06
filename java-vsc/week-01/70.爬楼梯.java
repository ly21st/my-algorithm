/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 *
 * https://leetcode-cn.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (48.71%)
 * Likes:    1014
 * Dislikes: 0
 * Total Accepted:    198K
 * Total Submissions: 406.3K
 * Testcase Example:  '2'
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * 注意：给定 n 是一个正整数。
 * 
 * 示例 1：
 * 
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 
 * 示例 2：
 * 
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * 
 * 
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        // f(i，n) = f(i+1, n) + f(i+2, n)
        if (n <= 1) {
            return 1;
        }
        int []arr = new int[n + 1];
        return helper(arr, 0, n);
    }

    public int helper(int []arr, int i, int n) {
        if (i > n) {
            return 0;
        }  else if (i == n) {
            return 1;
        }
        if (arr[i] > 0) {
            return arr[i];
        }
        arr[i] = helper(arr, i + 1, n) + helper(arr, i + 2, n);
        return arr[i];
    }
}
// @lc code=end

// 傻递归解法，压测超时
// class Solution {
//     public int climbStairs(int n) {
//         // f(n) = f(n-2) + f(n-1)
//         if (n == 0 || n == 1) {
//             return 1;
//         } 
//         return climbStairs(n - 2) + climbStairs(n - 1);
//     }
// }



// 解法1
// class Solution {
//     public int climbStairs(int n) {
//         // f(n) = f(n-2) + f(n-1)
//         if (n <= 1) {
//             return 1;
//         }
//         int a = 1, b = 1;
//         int c = 0;
//         int i = 2;
//         while (i <= n) {
//             c = a + b;
//             a = b;
//             b = c;
//             i++;
//         }
//         return c;
//     }
// }



// 用中间数组，循环方法
// class Solution {
//     public int climbStairs(int n) {
//         // f(n) = f(n-2) + f(n-1)
//         if (n <= 1) {
//             return 1;
//         }
//         int []arr = new int[n + 1];
//         arr[0] = arr[1] = 1;
//         for (int i = 2; i <= n; i++) {
//             arr[i] = arr[i - 2] + arr[i - 1];
//         }
//         return arr[n];
//     }
// }



// 递归+记忆化数组
// class Solution {
//     public int climbStairs(int n) {
//         // f(n) = f(n-2) + f(n-1)
//         if (n <= 1) {
//             return 1;
//         }
//         int []arr = new int[n + 1];
//         return helper(arr, n);
//     }

//     public int helper(int []arr, int n) {
//         if (n <= 1) {
//             return 1;
//         }
//         if (arr[n] !=0) {
//             return arr[n];
//         }
//         arr[n] = helper(arr, n - 2) + helper(arr, n - 1);
//         return arr[n];
//     }
// }
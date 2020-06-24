import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 *
 * https://leetcode-cn.com/problems/coin-change/description/
 *
 * algorithms
 * Medium (39.71%)
 * Likes:    657
 * Dislikes: 0
 * Total Accepted:    95.5K
 * Total Submissions: 238.7K
 * Testcase Example:  '[1,2,5]\n11'
 *
 * 给定不同面额的硬币 coins 和一个总金额
 * amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3 
 * 解释: 11 = 5 + 5 + 1
 * 
 * 示例 2:
 * 
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 
 * 
 * 
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * 
 */

// @lc code=start
// 根据官方解答对边界进行处理优化，增加代码可读性
class Solution {
    public int coinChange(int[] coins, int amount) {
        int coinsLen = coins.length;
        int[] dp = new int[amount + 1];
        if (amount == 0) {
            return 0;
        }
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        // dp[amount] = min(dp[amount-coins[0]]，dp[amount-coins[1]) + 1
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coinsLen; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] < amount+1 ? dp[amount] : -1;
    }
}
// @lc code=end


// 动态规划方法1
// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int coinsLen = coins.length;
//         int[] dp = new int[amount + 1];
//         if (amount == 0) {
//             return 0;
//         }
//         // dp[amount] = min(dp[amount-coins[0]]，dp[amount-coins[1]) + 1
//         for (int i = 1; i <= amount; i++) {
//             int min = Integer.MAX_VALUE;
//             for (int j = 0; j < coinsLen; j++) {
//                 if (i - coins[j] >= 0 && dp[i - coins[j]] >= 0) {
//                     min = Math.min(min, dp[i - coins[j]]);
//                 }
//             }
//             dp[i] = min == Integer.MAX_VALUE ? -1 : min + 1;
//         }
//         return dp[amount] > 0 ? dp[amount] : -1;
//     }
// }
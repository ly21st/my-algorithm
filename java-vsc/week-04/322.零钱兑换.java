import java.util.Collections;

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
class Solution {
    int minCount = -1;
    boolean found = false;
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        reverse(coins);
        int n = coins.length;
        helper(coins, n, amount, 0, 0);
        return minCount;
    }

    public void helper(int[] coins, int n, int amount, int level, int count) {
        if (level == n) {
            return;
        }
        if (found) {
            return;
        }
        int m = amount / coins[level];
        if ( amount % coins[level] == 0) {
            count += m;
            minCount = count;
            found = true;
            return;
        }
        for (int i = m; i >= 0; i--) {
            count += i;
            helper(coins, n, amount - coins[level] * i, level + 1, count);
            count -= i;
        }
    }

    public void reverse(int []arr) {
        int n = arr.length;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}
// @lc code=end


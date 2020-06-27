/*
 * @lc app=leetcode.cn id=123 lang=java
 *
 * [123] 买卖股票的最佳时机 III
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 *
 * algorithms
 * Hard (42.80%)
 * Likes:    418
 * Dislikes: 0
 * Total Accepted:    39.7K
 * Total Submissions: 91.7K
 * Testcase Example:  '[3,3,5,0,0,3,1,4]'
 *
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 
 * 示例 1:
 * 
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 * 随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 
 * 示例 2:
 * 
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4
 * 。   
 * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
 * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 
 * 
 * 示例 3:
 * 
 * 输入: [7,6,4,3,1] 
 * 输出: 0 
 * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 * 
 */

// @lc code=start
// 动态规划方法2
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int [][][]dp = new int[n][2][3];
        // dp[i][0][k] 第i天不持有，已进行k次卖出最大利润
        // dp[i][1][k] 第i天持有，已进行k次卖出最大利润
        dp[0][0][0] = 0;
        dp[0][0][1] = 0;
        dp[0][0][2] = 0;
        dp[0][1][0] = -prices[0];
        dp[0][1][1] = Integer.MIN_VALUE;
        dp[0][1][2] = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Math.max(dp[i-1][0][1], dp[i-1][1][0] + prices[i]);
            dp[i][0][2] = Math.max(dp[i-1][0][2], dp[i-1][1][1] + prices[i]);

            dp[i][1][0] = Math.max(dp[i-1][1][0], dp[i-1][0][0] - prices[i]);
            dp[i][1][1] = Math.max(dp[i-1][1][1], dp[i-1][0][1] - prices[i]);
            dp[i][1][2] = Integer.MIN_VALUE;
        }

        int max = 0;
        max = Math.max(dp[n-1][0][0], dp[n-1][0][1]);
        max = Math.max(max, dp[n-1][0][2]);
        return max;
    }
}
// @lc code=end


// 两段最大利润法
// class Solution {
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int maxprofit = 0;
//         for (int i = 0; i < n; i++) {
//             int p = getMaxProfit(prices, 0, i) + getMaxProfit(prices, i, n);
//             maxprofit = Math.max(maxprofit, p);
//         }
//         return maxprofit;
//     }

//     public int getMaxProfit(int[] prices, int first, int end) {
//         if (end <= first) {
//             return 0;
//         }
//         int minPrice = Integer.MAX_VALUE;
//         int profit = 0;
//         for (int i = first; i < end; i++) {
//             if (minPrice > prices[i]) {
//                 minPrice = prices[i];
//             } else {
//                 profit = Math.max(profit, prices[i]-minPrice);
//             }
//         }
//         return profit;
//     }
// }



// 两段最大利润法，根据网友代码编写，时间复杂度O(n)
// class Solution {
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int maxProfit = 0;
//         if (n == 0) {
//             return 0;
//         }
//         int minPrice = prices[0];
//         int maxPrice = prices[n-1];
//         int profit1 = 0;
//         int profit2 = 0;
//         int []dp1 = new int[n];
//         int []dp2 = new int[n];
//         for (int i = 0; i < n; i++) {
//             if (prices[i] < minPrice) {
//                 minPrice = prices[i];
//             } else {
//                 profit1 = Math.max(profit1, prices[i] - minPrice);
//             }
//             dp1[i] = profit1;
//             if (prices[n-1-i] > maxPrice) {
//                 maxPrice = prices[n-1-i];
//             } else {
//                 profit2 = Math.max(profit2, maxPrice - prices[n-1-i]);
//             }
//             dp2[n-1-i] = profit2;
//         }
//         for (int i = 0; i < n; i++) {
//             maxProfit = Math.max(maxProfit, dp1[i] + dp2[i]);
//         }
//         return maxProfit;
//     }
// }



// 动态规划法
// class Solution {
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         if (n == 0) {
//             return 0;
//         }
//         int minPrice = Integer.MAX_VALUE;
//         int profit1 = 0;
//         int profitAfterBuy = Integer.MIN_VALUE;
//         int curProfit = 0;
//         for (int i = 0; i < n; i++) {
//             minPrice = Math.min(minPrice, prices[i]);
//             profit1 = Math.max(profit1, prices[i] - minPrice);
//             profitAfterBuy = Math.max(profitAfterBuy, profit1 - prices[i]);
//             curProfit = Math.max(curProfit, profitAfterBuy + prices[i]);
//         }
//         return curProfit;
//     }
// }


// 动态规划方法3 
// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--29/



// 状态机方法
// int maxProfit(vector<int>& prices) {
//     if(prices.empty()) return 0;
//     //进行初始化，第一天 s1 将股票买入，其他状态全部初始化为最小值
//     int s1=-prices[0],s2=INT_MIN,s3=INT_MIN,s4=INT_MIN;

//     for(int i=1;i<prices.size();++i) {            
//         s1 = max(s1, -prices[i]); //买入价格更低的股
//         s2 = max(s2, s1+prices[i]); //卖出当前股，或者不操作
//         s3 = max(s3, s2-prices[i]); //第二次买入，或者不操作
//         s4 = max(s4, s3+prices[i]); //第二次卖出，或者不操作
//     }
//     return max(0,s4);
// }


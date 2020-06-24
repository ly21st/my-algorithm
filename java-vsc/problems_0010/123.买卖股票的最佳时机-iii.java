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
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxprofit = 0;
        for (int i = 0; i < n; i++) {
            int p = getMaxProfit(prices, 0, i) + getMaxProfit(prices, i, n);
            maxprofit = Math.max(maxprofit, p);
        }
        return maxprofit;
    }

    public int getMaxProfit(int[] prices, int first, int end) {
        if (end <= first) {
            return 0;
        }
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = first; i < end; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            } else {
                profit = Math.max(profit, prices[i]-minPrice);
            }
        }
        return profit;
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
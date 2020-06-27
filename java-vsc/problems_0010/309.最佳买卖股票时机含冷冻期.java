/*
 * @lc app=leetcode.cn id=309 lang=java
 *
 * [309] 最佳买卖股票时机含冷冻期
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 *
 * algorithms
 * Medium (53.48%)
 * Likes:    345
 * Dislikes: 0
 * Total Accepted:    28.7K
 * Total Submissions: 53.3K
 * Testcase Example:  '[1,2,3,0,2]'
 *
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * 
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 
 * 
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 
 * 
 * 示例:
 * 
 * 输入: [1,2,3,0,2]
 * 输出: 3 
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * 
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        if (n < 3) {
            if (prices[1] > prices[0]) {
                return prices[1] - prices[0];
            } else {
                return 0;
            }
        }
        int [][]dp = new int[n][2];
        // dp[i][0]，第i天不持有最大利润；
        // dp[i][1], 第i天持有最大利润
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], -prices[1]);
        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - prices[i]);
        }
        return dp[n-1][0];
    }
}
// @lc code=end


// 代码收藏
// class Solution {
//     public int maxProfit(int[] prices) {
//         int len = prices.length;
//         if (len < 2) return 0;

//         //0表示本不持有，1表示持有，2表示当天卖出，不持有
//         int[][] dp = new int[len][3];  //用二维数组记录当天各种情况的最优解(收益的最大值)
//         dp[0][1] = -prices[0];  //第一天若持有，则收益为负；不持有则收益为零

//         for (int i = 1; i < len; i++){
//             dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);  //当天的本不持有可以由前一天本不持有或前一天卖出得到
//             dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);  //当天的持有可以由前一天的持有或前一天的本不持有-当天的股票价格得到, 即买进一只股票
//             dp[i][2] = dp[i - 1][1] + prices[i];  //当天卖出可以由前一天的持有+当天的股票价格得到, 即卖出手中的股票
//         }
//         return Math.max(dp[len - 1][0], dp[len - 1][2]);  //返回最后一天不持有股票的状态，此处可以得到收益的最大值
//     }
// }



// 代码收藏，优化空间复杂度
// class Solution {
//     public int maxProfit(int[] prices) {
//         int len = prices.length;
//         if (len < 2) return 0;

//         //x表示本不持有，y表示持有，z表示当天卖出，不持有
//         int x = 0, y = -prices[0], z = 0;
// //        int[][] dp = new int[len][3];
// //        dp[0][1] = -prices[0];

//         for (int i = 1; i < len; i++){
//             int temp = y;
//             y = Math.max(y, x - prices[i]);
//             //dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);

//             x = Math.max(x, z);
//             //dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);

//             z = y + prices[i];
//             //dp[i][2] = dp[i - 1][1] + prices[i];
//         }
//         return Math.max(x, z);
//     }
// }



// 代码收藏

// class Solution {
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         if (n <= 1)
//             return 0;

//         int[][] dp = new int[n][3];
//         dp[0][0] = 0;
//         dp[0][1] = -1 * prices[0];
//         dp[0][2] = 0;

//         for (int i = 1; i < n; i++) {// 从[1]...[n-1]
//             dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
//             dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
//             dp[i][2] = dp[i - 1][1] + prices[i];

//         }

//         return Math.max(dp[n - 1][0], dp[n - 1][2]);
//     }
// }





解法一。先放C++代码，二维动态规划解法。
/*
dp[len][2]

case 1: We have a stock on day i, dp[i][1] (calculate the max of the below)
- I bought it today
    dp[i-2][0] - prices[i] 
- I am carry forwarding
    dp[i-1][1]

case 2: We have no stock on day i, dp[i][0] (calculate the max of the below)
- I sold it today
    dp[i-1][1] + prices[i]
- I am carry forwarding, doing nothing
    dp[i-1][0]
*/

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int len = prices.size();
        if(len <= 1) return 0; // 特殊情况处理

        if(len==2 && prices[0]>=prices[1]) return 0; // 特殊情况处理
        else if(len == 2 && prices[0]<prices[1]) return prices[1]-prices[0]; // 特殊情况处理

        int dp[len][2]; // 二维动态规划开始

        dp[0][0] = 0; // 第一天，不持有股票
        dp[0][1] = -prices[0]; // 第一天，持有股票
        dp[1][0] = max(dp[0][0], dp[0][1] + prices[1]); // 第二天，不持有股票
        dp[1][1] = max(dp[0][0]-prices[1], dp[0][1]); // 第二天，持有股票

        for(int i=2;i<len;++i)
        {
            dp[i][0] = max(dp[i-1][1] + prices[i], dp[i-1][0]); // 第i天，不持有股票
            dp[i][1] = max(dp[i-2][0] - prices[i], dp[i-1][1]); // 第i天，持有股票
        }

        return dp[len-1][0];
    }
};

执行结果截图

解题思路


首先明确一个中心思路，第i天的情况只有可能是两种：持有股票，或者不持有股票。


我们用二维动态规划来得到每一天的最大利润和。首先定义一个二维数组dp[len][2]，列数是prices的大小（也就是一共有多少天），行数是2（第一行表示不持有股票，第二行表示持有股票）。也就是说比dp[0][0]则是表示第1天不持有股票的情况；dp[2][1]则是表示第3天持有股票的情况。


如果是持有股票，可以进一步分为是在当天买了这支股票，和之前某天就买了，第i天继续持有。



如果第i天是持有股票+在当天买了这只股票的状态，那么第i-1天一定是冷冻期（cooldown），因为必须要先卖才能买，而卖了之后就会有一天冷冻期。因此在第i天的最大利润和就是第i-2天的最大利润和 - 第i天的价格（可以理解为收入-成本=利润），即dp[i-2][0] - prices[i]。（之所以是dp[i-2][0]，是因为在第i-2天卖出去了，即不持有股票，所以是[0]）
如果第i天是持有股票+之前某天就买了，第i天继续持有的状态，那么第i天没有做任何操作，与第i-1天是一样的，即dp[i-1][1]。
所以持有股票的状态下，最大利润和就是dp[i][1] = max(dp[i-2][0] - prices[i], dp[i-1][1])。


如果是不持有股票，可以进一步分为是在当天卖了这支股票，和之前就卖了，第i天也没有买入。


如果第i天是不持有股票+在当天卖了这支股票的状态，那么昨天必然是持有股票的，最大收益就是今天的价格 - 第i-1天买股票花的钱，即dp[i-1][1] + prices[i]。
如果第i天是不持有股票+之前就卖了，第i天也没有买入的状态，那么之前一天也已经是不持有股票的，那么最大收益就是dp[i-1][0]。
所以不持有股票的状态下，最大利润和就是dp[i][0] = max(dp[i-1][1] + prices[i], dp[i-1][0])。



注意，由于代码中出现了i-2，所以我们的i最小也要从2开始，也就是说我们必须先手动考虑dp[0][0], dp[0][1], dp[1][0], dp[1][1]四种情况（在代码中已写好，不做多余解释了）。


思路如有写得有问题的地方，还要麻烦大家评论区中指出🦆。


Reference
https://www.youtube.com/watch?v=w6xk5Po-DX0
解法二（更优化）。先放C++代码，时间复杂度是O(n)，但是空间复杂度降为了O(1)，因为每一次的运算只跟前一天有关系。
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int len = prices.size();

        if(len <= 1) return 0;

        vector<int> hold(len, 0);
        vector<int> rest(len, 0);
        vector<int> sold(len, 0);

        hold[0] = -prices[0];
        rest[0] = 0;
        sold[0] = INT_MIN;

        for(int i=1;i<len;++i)
        {
            hold[i] = max(hold[i-1], rest[i-1]-prices[i]);
            rest[i] = max(rest[i-1], sold[i-1]);
            sold[i] = hold[i-1] + prices[i];
        }

        return max(rest[len-1], sold[len-1]);
    }
};

作者：superkakayong
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/zi-jie-ti-ku-zhong-deng-5mai-mai-gu-piao-de-zui-ji/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 *
 * https://leetcode-cn.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (23.75%)
 * Likes:    415
 * Dislikes: 0
 * Total Accepted:    53K
 * Total Submissions: 222.6K
 * Testcase Example:  '"12"'
 *
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 
 * 示例 1:
 * 
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n < 1) {
            return 0;
        }
        if (n < 2) {
            int num = Integer.parseInt(s);
            if (num >= 1 && num <= 26) {
                return 1;
            } else {
                return 0;
            }
        }
        int []dp = new int[n+1];
        dp[1] = 1;
        String str = s.substring(0,2);
        int num = Integer.parseInt(str);
        if (num >= 1 && num <= 26) {
            dp[2] = 2;
        } else {
            dp[2] = 1;
        }
        for (int i = 2; i < n; i++) {
            num = Integer.parseInt(s.substring(i-1, i+1));
            if (num >= 1 && num <= 26) {
                dp[i+1] = dp[i-1] + dp[i];
            } else {
                dp[i+1] = dp[i];
            }
        }
        return dp[n];
    }
}
// @lc code=end


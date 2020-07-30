/*
 * @lc app=leetcode.cn id=1143 lang=java
 *
 * [1143] 最长公共子序列
 *
 * https://leetcode-cn.com/problems/longest-common-subsequence/description/
 *
 * algorithms
 * Medium (59.55%)
 * Likes:    158
 * Dislikes: 0
 * Total Accepted:    25.9K
 * Total Submissions: 43.2K
 * Testcase Example:  '"abcde"\n"ace"'
 *
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 * 
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde"
 * 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 * 
 * 若这两个字符串没有公共子序列，则返回 0。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入：text1 = "abcde", text2 = "ace" 
 * 输出：3  
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * 
 * 
 * 示例 2:
 * 
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 * 
 * 
 * 示例 3:
 * 
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * 输入的字符串只含有小写英文字符。
 * 
 * 
 */

// @lc code=start
// 简洁做法
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();
        int m = arr1.length;
        int n = arr2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
// @lc code=end

// 动态规划法
// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         char[] arr1 = text1.toCharArray();
//         char[] arr2 = text2.toCharArray();
//         int m = arr1.length;
//         int n = arr2.length;
//         if (m < 1 || n < 1) {
//             return 0;
//         }
//         int[][] dp = new int[m][n];
//         if (arr1[0] == arr2[0]) {
//             dp[0][0] = 1;
//         } else {
//             dp[0][0] = 0;
//         }
//         for (int j = 1; j < n; j++) {
//             if (dp[0][j - 1] == 1) {
//                 dp[0][j] = 1;
//             } else if (arr1[0] == arr2[j]) {
//                 dp[0][j] = 1;
//             }
//         }
//         for (int i = 1; i < m; i++) {
//             if (dp[i - 1][0] == 1) {
//                 dp[i][0] = 1;
//             } else if (arr1[i] == arr2[0]) {
//                 dp[i][0] = 1;
//             }
//         }
//         for (int i = 1; i < m; i++) {
//             for (int j = 1; j < n; j++) {
//                 if (arr1[i] == arr2[j]) {
//                     dp[i][j] = dp[i - 1][j - 1] + 1;
//                 } else {
//                     dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                 }
//             }
//         }
//         return dp[m - 1][n - 1];
//     }
// }


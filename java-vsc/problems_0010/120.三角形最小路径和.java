/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 *
 * https://leetcode-cn.com/problems/triangle/description/
 *
 * algorithms
 * Medium (64.72%)
 * Likes:    426
 * Dislikes: 0
 * Total Accepted:    63.2K
 * Total Submissions: 97.4K
 * Testcase Example:  '[[2],[3,4],[6,5,7],[4,1,8,3]]'
 *
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 
 * 
 * 
 * 例如，给定三角形：
 * 
 * [
 * ⁠    [2],
 * ⁠   [3,4],
 * ⁠  [6,5,7],
 * ⁠ [4,1,8,3]
 * ]
 * 
 * 
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 
 * 
 * 
 * 说明：
 * 
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * 
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int []dp = new int[n];
        int []pre = new int[n];
        if (n == 0) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            List<Integer> rows = triangle.get(i);
            for (int j = 0; j < rows.size(); j++) {
                if (j == 0) {
                    dp[j] = pre[j] + rows.get(j);
                } else if (j == rows.size()-1) {
                    dp[j] = pre[j-1] + rows.get(j);
                }
                else {
                    dp[j] = Math.min(pre[j-1], pre[j]) + rows.get(j);
                }
            } 
            
            for (int k = 0; k < n; k++) {
                pre[k] = dp[k];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (min > dp[i]) {
                min = dp[i];
            }
        }
        return min;
    }
}
// @lc code=end


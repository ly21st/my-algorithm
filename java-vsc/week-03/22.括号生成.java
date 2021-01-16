import java.util.List;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 *
 * https://leetcode-cn.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (76.70%)
 * Likes:    1514
 * Dislikes: 0
 * Total Accepted:    217.4K
 * Total Submissions: 283.5K
 * Testcase Example:  '3'
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：n = 3
 * 输出：[
 * ⁠      "((()))",
 * ⁠      "(()())",
 * ⁠      "(())()",
 * ⁠      "()(())",
 * ⁠      "()()()"
 * ⁠    ]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, "", 0, 0, n);
        return res;
    }

    public void helper(List<String> res, String s, int leftCnt, int rightCnt, int n) {
        if (rightCnt == n) {
            res.add(s);
            return;
        }
        // 放"("
        if (leftCnt < n) {
            helper(res, s + "(", leftCnt + 1, rightCnt, n);
        } 
        // 放)
        if (rightCnt < leftCnt) {
            helper(res, s + ")", leftCnt, rightCnt + 1, n);
        } 
    }
}
// @lc code=end


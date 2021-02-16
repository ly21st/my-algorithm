import org.graalvm.compiler.nodes.calc.RightShiftNode;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 *
 * https://leetcode-cn.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (76.78%)
 * Likes:    1556
 * Dislikes: 0
 * Total Accepted:    226.7K
 * Total Submissions: 295.2K
 * Testcase Example:  '3'
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 1
 * 输出：["()"]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList [] cache = new ArrayList[n + 1];
        
        return generate(n, cache);
    }

    public List<String> generate(int n, ArrayList []cache) {
        if (cache[n] != null) {
            return cache[n];
        }
        ArrayList<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
            return ans;
        }
        for (int i = 0; i < n; i++) {
            for (String left : generate(i, cache)) {
                for (String right : generate(n - 1 - i, cache)) {
                    String tmp = "(" +  left + ")" + right;
                    ans.add(tmp);
                }
            }
        }
        cache[n] = ans;
        return ans;
    }

}
// @lc code=end


// 深度优先算法求解
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        dfs(res, "", n, 0, 0);
        return res;
    }

    public void dfs(List<String> res, String output, int n, int leftCnt, int rightCnt) {
        if (rightCnt >= n) {
            res.add(output);
            return;
        }
        if (leftCnt < n) {
            dfs(res, output + "(", n, leftCnt + 1, rightCnt);
        }
        if (rightCnt < leftCnt) {
            dfs(res, output + ")", n, leftCnt, rightCnt + 1);
        }
    }
}


// 动态规划法
class Solution {
    public List<String> generateParenthesis(int n) {
        List<List<String>> dp = new ArrayList<>();
        if (n == 0) {
            return dp.get(0);
        }
        dp.add(new ArrayList<String>() {
            {
                add("");
            }
        });
        dp.add(new ArrayList<String>() {
            {
                add("()");
            }
        });
        for (int i = 2; i <= n; i++) {
            List<String> output = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i - 1 - j);
                for (String left : str1) {
                    for (String right : str2) {
                        output.add("(" + left + ")" + right);
                    }
                }
            }
            dp.add(output);
        }
        return dp.get(n);
    }

}
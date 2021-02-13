import sun.jvm.hotspot.oops.IntField;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 *
 * https://leetcode-cn.com/problems/n-queens/description/
 *
 * algorithms
 * Hard (69.70%)
 * Likes:    419
 * Dislikes: 0
 * Total Accepted:    43.6K
 * Total Submissions: 62.4K
 * Testcase Example:  '4'
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 
 * 
 * 
 * 上图为 8 皇后问题的一种解法。
 * 
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 
 * 示例:
 * 
 * 输入: 4
 * 输出: [
 * ⁠[".Q..",  // 解法 1
 * ⁠ "...Q",
 * ⁠ "Q...",
 * ⁠ "..Q."],
 * 
 * ⁠["..Q.",  // 解法 2
 * ⁠ "Q...",
 * ⁠ "...Q",
 * ⁠ ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 
 * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步，可进可退。（引用自
 * 百度百科 - 皇后 ）
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int []output = new int[n];
        int []col = new int[n];
        int []slave = new int[2 * n - 1];
        int []reSlave = new int[2 * n - 1];
        dfs(res, output, n, 0, col, slave, reSlave);
        return res;
    }

    public void dfs(List<List<String>> res, int[] output, int n, 
        int first, int[] col, int[] slave, int[] reSlave) {
        if (first == n) {
            List<String> tmp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < n; j++) {
                    if (output[i] == j) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                tmp.add(sb.toString());
            }
            res.add(tmp);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (col[i] == 0 && slave[first + i] == 0 
                && reSlave[first - i + n - 1] == 0) {
                    col[i] = 1;
                    slave[first + i] = 1;
                    reSlave[first - i + n - 1] = 1;
                    output[first] = i;
                    dfs(res, output, n, first + 1, col, slave, reSlave);
                    col[i] = 0;
                    slave[first + i] = 0;
                    reSlave[first - i + n - 1] = 0;
                }
        }

    }
}
// @lc code=end


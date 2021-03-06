/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N皇后 II
 *
 * https://leetcode-cn.com/problems/n-queens-ii/description/
 *
 * algorithms
 * Hard (78.55%)
 * Likes:    124
 * Dislikes: 0
 * Total Accepted:    24.3K
 * Total Submissions: 31K
 * Testcase Example:  '4'
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 
 * 
 * 
 * 上图为 8 皇后问题的一种解法。
 * 
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 * 
 * 示例:
 * 
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * 
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 
 * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或七步，可进可退。（引用自
 * 百度百科 - 皇后 ）
 * 
 * 
 */

// @lc code=start
class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        int []cols = new int[n];
        int []pie = new int[2 * n - 1];
        int []na = new int[2 * n - 1];
        int [][]output = new int[n][n];
        dfs(n, 0, output, cols, pie, na);
        return count;
    }

    public void dfs(int n, int level, int[][] output, int[] cols, int[] pie, int[] na) {
        if (level == n) {
            count++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if (cols[j] != 1 && pie[level + j] != 1 && na[n - 1 + level - j] != 1) {
                cols[j] = 1;
                pie[level + j] = 1;
                na[n - 1 + level - j] = 1;
                output[level][j] = 1;
                dfs(n, level + 1, output, cols, pie, na);
                cols[j] = 0;
                pie[level + j] = 0;
                na[n - 1 + level - j] = 0;
                output[level][j] = 0;
            }
        }
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N皇后 II
 *
 * https://leetcode-cn.com/problems/n-queens-ii/description/
 *
 * algorithms
 * Hard (78.54%)
 * Likes:    134
 * Dislikes: 0
 * Total Accepted:    28.1K
 * Total Submissions: 35.5K
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
        int []slave = new int[2 * n - 1];
        int []rslave = new int[2 * n - 1];
        int[][]output = new int[n][n];
        helper(0, n, output, cols, slave, rslave);
        return count;
    }

    public void helper(int row, int n, int[][]output, int []cols, 
                        int[] slave, int[] rslave) {
        if (row == n) {
            count++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if (cols[j] == 0 && slave[row+j] == 0 && rslave[n-1+row-j] == 0) {
                output[row][j] = 1;
                cols[j] = 1;
                slave[row+j] = 1;
                rslave[n-1+row-j] = 1;
                helper(row+1, n, output, cols, slave, rslave);
                output[row][j] = 0;
                cols[j] = 0;
                slave[row+j] = 0;
                rslave[n-1+row-j] = 0;
            }
        }
    }
}
// @lc code=end


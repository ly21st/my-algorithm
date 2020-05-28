import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 *
 * https://leetcode-cn.com/problems/n-queens/description/
 *
 * algorithms
 * Hard (68.69%)
 * Likes:    396
 * Dislikes: 0
 * Total Accepted:    39K
 * Total Submissions: 56.2K
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
 * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或七步，可进可退。（引用自
 * 百度百科 - 皇后 ）
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<String>> solveNQueens(int n) {
        int []cols = new int[n + 1];
        int []slash = new int[2 * n - 1];
        int []backSlash = new int[2 * n - 1];
        List<List<String>> res = new ArrayList<List<String>>();
        int [][]arr = new int[n][n];
        helper(0, n, res, arr, cols, slash, backSlash);
        return res;
    }

    public void helper(int level, int n, List<List<String>> res, int [][]arr,
                    int []cols, int []slash, int []backSlash) {
        if (level == n) {
            List<String> list = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 0) {
                        sb.append(".");
                    } else {
                        sb.append("Q");
                    }
                }
                list.add(sb.toString());
            }
            res.add(list);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (cols[j] != 1 && slash[level + j] != 1 && backSlash[n - 1 + level - j] != 1) {
                arr[level][j] = 1;
                cols[j] = 1;
                slash[level + j] = 1;
                backSlash[n - 1 + level - j] = 1;
                helper(level + 1, n, res, arr, cols, slash, backSlash);
                arr[level][j] = 0;
                cols[j] = 0;
                slash[level + j] = 0;
                backSlash[n - 1 + level - j] = 0;
            }
        }
    }
}
// @lc code=end


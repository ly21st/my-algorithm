/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 *
 * https://leetcode-cn.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (52.32%)
 * Likes:    982
 * Dislikes: 0
 * Total Accepted:    207K
 * Total Submissions: 394.8K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 
 * 此外，你可以假设该网格的四条边均被水包围。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：grid = [
 * ⁠ ["1","1","1","1","0"],
 * ⁠ ["1","1","0","1","0"],
 * ⁠ ["1","1","0","0","0"],
 * ⁠ ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：grid = [
 * ⁠ ["1","1","0","0","0"],
 * ⁠ ["1","1","0","0","0"],
 * ⁠ ["0","0","1","0","0"],
 * ⁠ ["0","0","0","1","1"]
 * ]
 * 输出：3
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 
 * grid[i][j] 的值为 '0' 或 '1'
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        if (n == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, m, n, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int m, int n, int x, int y) {
        if (grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        if (x - 1 >= 0) {
            dfs(grid, m, n, x - 1, y);
        }
        if (x + 1 < m) {
            dfs(grid, m, n, x + 1, y);
        }
        if (y - 1 >= 0) {
            dfs(grid, m, n, x, y - 1);
        }
        if (y + 1 < n) {
            dfs(grid, m, n, x, y + 1);
        }
    }
}
// @lc code=end


// 深度优先算法求解
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        if (n == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, m, n, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int m, int n, int x, int y) {
        if (grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        if (x - 1 >= 0) {
            dfs(grid, m, n, x - 1, y);
        }
        if (x + 1 < m) {
            dfs(grid, m, n, x + 1, y);
        }
        if (y - 1 >= 0) {
            dfs(grid, m, n, x, y - 1);
        }
        if (y + 1 < n) {
            dfs(grid, m, n, x, y + 1);
        }
    }
}
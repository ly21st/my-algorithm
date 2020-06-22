/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 *
 * https://leetcode-cn.com/problems/unique-paths-ii/description/
 *
 * algorithms
 * Medium (33.19%)
 * Likes:    303
 * Dislikes: 0
 * Total Accepted:    63.3K
 * Total Submissions: 189.1K
 * Testcase Example:  '[[0,0,0],[0,1,0],[0,0,0]]'
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 
 * 
 * 
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 
 * 说明：m 和 n 的值均不超过 100。
 * 
 * 示例 1:
 * 
 * 输入:
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * 
 * 
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    if (m == 0) {
        return 0;
    }
    int n = obstacleGrid[0].length;
    if (n == 0) {
        return 0;
    }
    int [][]dp = new int[m][n];
    if (obstacleGrid[0][0] == 1) {
        dp[0][0] = 0;
    } else {
        dp[0][0] = 1;
    }
    for (int j = 1; j < n; j++) {
        if (obstacleGrid[0][j] == 1) {
            dp[0][j] = 0;
        } else {
            if (dp[0][j-1] == 0) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = 1;
            }
        }
    }
    for (int i = 1; i < m; i++) {
        if (obstacleGrid[i][0] == 1) {
            dp[i][0] = 0;
        } else {
            if (dp[i-1][0] == 0) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = 1;
            }
        }
    }
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[i][j] == 1) {
                dp[i][j] = 0;
            } else {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
    }
    return dp[m-1][n-1];
}
}
// @lc code=end


// 网友代码，可读性不错
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        boolean iflag = false;
        boolean jflag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    if (i == 0) iflag = true;
                    if (j == 0) jflag = true;
                } else if (i == 0) {
                    dp[i][j] = iflag ? 0 : 1;
                } else if (j == 0) {
                    dp[i][j] = jflag ? 0 : 1;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
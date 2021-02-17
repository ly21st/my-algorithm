/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 *
 * https://leetcode-cn.com/problems/search-a-2d-matrix/description/
 *
 * algorithms
 * Medium (40.27%)
 * Likes:    317
 * Dislikes: 0
 * Total Accepted:    81.7K
 * Total Submissions: 202.8K
 * Testcase Example:  '[[1,3,5,7],[10,11,16,20],[23,30,34,60]]\n3'
 *
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 
 * 
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * m == matrix.length
 * n == matrix[i].length
 * 1 
 * -10^4 
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }
        return helper(matrix, target, m, n);
    }

    public boolean helper(int [][]matrix, int target, int m, int n) {
        int num = m * n;
        int low = 0; 
        int hight = num - 1;
        int mid; 
        while (low <= hight) {
            mid = low + (hight - low) / 2;
            int x = mid / n;
            int y = mid % n; 
            if (matrix[x][y] == target) {
                return true;
            }
            if (target < matrix[x][y]) {
                hight = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
// @lc code=end


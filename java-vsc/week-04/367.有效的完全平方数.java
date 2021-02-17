/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 *
 * https://leetcode-cn.com/problems/valid-perfect-square/description/
 *
 * algorithms
 * Easy (43.71%)
 * Likes:    191
 * Dislikes: 0
 * Total Accepted:    54.7K
 * Total Submissions: 125.1K
 * Testcase Example:  '16'
 *
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * 
 * 说明：不要使用任何内置的库函数，如  sqrt。
 * 
 * 示例 1：
 * 
 * 输入：16
 * 输出：True
 * 
 * 示例 2：
 * 
 * 输入：14
 * 输出：False
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        int n = binarySearch(num);
        if (n * n == num) {
            return true;
        } else {
            return false;
        }
    }

    public int binarySearch(int x) {
        int ans = -1;
        int mid;
        int low = 0; 
        int hight = x;
        while (low <= hight) {
            mid = low + (hight - low) / 2;
            if ((long)mid * mid <= x) {
                ans = mid;
                low = mid + 1;
            } else {
                hight = mid - 1;
            }
        }
        return ans;
    }

    public double abs(double x) {
        if (x > 0.0) {
            return x;
        } else {
            return -x;
        }
     }
}
// @lc code=end

// 牛顿迭代法求解
class Solution {
    public boolean isPerfectSquare(int num) {
        int n = sqrtx(num);
        if (n * n == num) {
            return true;
        } else {
            return false;
        }
    }

    public int sqrtx(int x) {
        double C = x;
        double x0 = C;
        double xi; 
        while (true) {
            xi = 1.0 / 2 * (x0 + C / x0);
            if (abs(xi * xi - x) < 1e-7) {
                return (int)xi;
            }
            x0 = xi;
        }
    }

    public double abs(double x) {
        if (x > 0.0) {
            return x;
        } else {
            return -x;
        }
     }
}
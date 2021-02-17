/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 *
 * https://leetcode-cn.com/problems/sqrtx/description/
 *
 * algorithms
 * Easy (39.20%)
 * Likes:    592
 * Dislikes: 0
 * Total Accepted:    257.5K
 * Total Submissions: 657K
 * Testcase Example:  '4'
 *
 * 实现 int sqrt(int x) 函数。
 * 
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 
 * 示例 1:
 * 
 * 输入: 4
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842..., 
 * 由于返回类型是整数，小数部分将被舍去。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        double C= x;
        double x0 = C;
        double xi;
        while (true) {
            xi = 1.0/2 * (x0 + C/x0);
            if (Math.abs(xi * xi - x) < 0.000001) {
                return (int)xi;
            }
            x0 = xi;
        }
    }
}
// @lc code=end


// 二分法求解
class Solution {
    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        double v = binarySearch(x, 0, x);
        return (int)v;
    }

    public double binarySearch(double x, double low, double hight) {
        double mid;
        while (low <= hight) {
            mid = low + (hight - low) / 2;
            double s = mid * mid;
            if (Math.abs(s - x) < 0.000001) {
                return mid;
            }
            if (s < x) {
                low = mid;
            } else {
                hight = mid;
            }
        }
        return low + (hight - low) / 2;
    }
}



// 官方二分解法
class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        return binarySearch(x, 0, x);
    }

    public int binarySearch(int x, int low, int hight) {
        int mid;
        int ans = -1;
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
}
/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 *
 * https://leetcode-cn.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (51.25%)
 * Likes:    1414
 * Dislikes: 0
 * Total Accepted:    349.4K
 * Total Submissions: 681.7K
 * Testcase Example:  '2'
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * 注意：给定 n 是一个正整数。
 * 
 * 示例 1：
 * 
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 
 * 示例 2：
 * 
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * 
 * 
 */

// @lc code=start
// 方程组f(i, n) = f(i + 1, n) + f(i + 2, n)
// 用arr[i]表示f(i, n)
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int []arr = new int[n + 1];
        arr[n - 1] = 1;
        arr[n - 2] = 2;
        for (int i = n - 3; i >= 0; i--) {
            arr[i] = arr[i + 1] + arr[i + 2];
        }
        return arr[0];
    }
}
// @lc code=end


// 简单递归，会超时
class Solution {
    public int climbStairs(int n) {
        return helper(n);
    }

    public int helper(int n) {
        if (n <= 2) {
            return n;
        }
        return helper(n - 2) + helper(n - 1);
    }
}


// 带有记忆化数组的递归
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int []m = new int[n + 1];
        m[1] = 1;
        m[2] = 2;
        return helper(n, m);
    }

    public int helper(int n, int []m) {
        if (n <= 2) {
            return n;
        }
        if (m[n] != 0) {
            return m[n];
        }
        m[n] = helper(n - 1, m) + helper(n - 2, m);
        return m[n];
    }
}


// 斐波那契数列
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int []arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

}



// 斐波那契数列,不保存中间结果
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int a = 1;
        int b = 2;
        int c = 3;
        int i = 3; 
        while (i <= n) {
            c = a + b;
            a = b; 
            b = c;
            i++;
        }
        return c;
    }

}



// @lc code=start
// 方程组f(i, n) = f(i + 1, n) + f(i + 2, n)
// 用arr[i]表示f(i, n)
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int []arr = new int[n + 1];
        return helper(0, arr, n);
    }

    public int helper(int i, int []arr, int n) {
        if (i == n) {
            return 1; 
        } 
        if (i > n) {
            return 0;
        }
        if (arr[i] != 0) {
            return arr[i];
        }
        arr[i] = helper(i + 1, arr, n) + helper(i + 2, arr, n);
        return arr[i];
    }
}
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 *
 * https://leetcode-cn.com/problems/ugly-number-ii/description/
 *
 * algorithms
 * Medium (54.26%)
 * Likes:    407
 * Dislikes: 0
 * Total Accepted:    36.9K
 * Total Submissions: 67.9K
 * Testcase Example:  '10'
 *
 * 编写一个程序，找出第 n 个丑数。
 * 
 * 丑数就是质因数只包含 2, 3, 5 的正整数。
 * 
 * 示例:
 * 
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 
 * 说明:  
 * 
 * 
 * 1 是丑数。
 * n 不超过1690。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int nthUglyNumber(int n) {
        Set<Integer> set = new HashSet<>();
        if (n <= 6) return n; 
        for (int i = 1; i <= 6; i++) {
            set.add(i);
        }
        int i = 6; 
        int count = 6;
        while (count < n) {
            i++;
            if (isUglyNumber(i, set)) {
                set.add(i);
                count++;
            } 
        }
        return i;
    }

    public boolean isUglyNumber(int i, Set<Integer> set) {
        int j;
        j = i / 2;
        if (i % 2 == 0 && set.contains(j)) {
            return true;
        }
        j = i / 3;
        if (i % 3 == 0 && set.contains(j)) {
            return true;
        }
        j = i / 5;
        if (i % 5 == 0 && set.contains(j)) {
            return true;
        }
        return false;
    }
}
// @lc code=end


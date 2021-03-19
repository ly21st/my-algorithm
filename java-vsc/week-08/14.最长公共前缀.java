/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 *
 * https://leetcode-cn.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (39.22%)
 * Likes:    1510
 * Dislikes: 0
 * Total Accepted:    470.4K
 * Total Submissions: 1.2M
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 
 * 0 
 * strs[i] 仅由小写英文字母组成
 * 
 * 
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int strsLen = strs.length;
        int minLen = strs[0].length();
        for (int i = 0; i < strsLen; i++) {
            if (strs[i].length() < minLen) {
                minLen = strs[i].length();
            }
        }
        boolean flag = false;
        int j;
        for (j = 0; j < minLen; j++) {
            char c = strs[0].charAt(j);
            for (int i = 1; i < strsLen; i++) {
                if (c != strs[i].charAt(j)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        return strs[0].substring(0, j);
    }
}
// @lc code=end


// 解法1 
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int strsLen = strs.length;
        int minLen = strs[0].length();
        char [][]arrs = new char[strs.length][];
        for (int i = 0; i < strsLen; i++) {
            arrs[i] = strs[i].toCharArray();
            if (minLen > arrs[i].length) {
                minLen = arrs[i].length;
            }
        }
        int i = 0;
        boolean flag = false;
        for (i = 0; i < minLen; i++) {
            char c = arrs[0][i];
            for (int j = 1; j < strsLen; j++) {
                if (c != arrs[j][i]) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        return strs[0].substring(0, i);
    }
}
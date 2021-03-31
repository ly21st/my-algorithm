import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 *
 * https://leetcode-cn.com/problems/zigzag-conversion/description/
 *
 * algorithms
 * Medium (49.81%)
 * Likes:    1085
 * Dislikes: 0
 * Total Accepted:    233.7K
 * Total Submissions: 469.3K
 * Testcase Example:  '"PAYPALISHIRING"\n3'
 *
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 *
 * string convert(string s, int numRows);
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 *
 * 示例 2：
 *
 *
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 *
 * 示例 3：
 *
 *
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *
 *
 *
 *
 * 提示：
 *
 *
 * 1
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1
 *
 *
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        int n = s.length();
        List<List<Character>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new ArrayList<Character>());
        }
        return helper(s, list, numRows);
    }

    public String  helper(String s,  List<List<Character>> sbArr,  int numRows) {
        char[] cArr = s.toCharArray();
        int direction = 0;
        int x = 0;
        int y = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (direction == 0) {
                 sbArr.get(x).add(cArr[i]);
                if (x == numRows - 1) {
                    direction = 1;
                    x = x - 1;
                    y = y + 1;
                } else {
                    x++;
                }
            } else {
                sbArr.get(x).add(cArr[i]);
                if (x == 0) {
                    direction = 0;
                    x = x + 1;
                } else {
                    x = x - 1;
                    y = y + 1;
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            int n = sbArr.get(i).size();
            char []tmp = new char[n];
            for (int j = 0; j < n; j++) {
                tmp[j] = sbArr.get(i).get(j);
            }
            sb.append(new String(tmp));
        }
        return sb.toString();
    }
}
// @lc code=end


// 解法1
class Solution {
    public String convert(String s, int numRows) {
        if (s.length() == 0) {
            return "";
        }
        if (numRows <= 1) {
            return s;
        }
        StringBuffer[] sbArr = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) {
            sbArr[i] = new StringBuffer();
        }
        return helper(s, sbArr, numRows);
    }

    public String  helper(String s, StringBuffer[] sbArr,  int numRows) {
        char[] cArr = s.toCharArray();
        int direction = 0;
        int x = 0;
        int y = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (direction == 0) {
                sbArr[x].append(cArr[i]);
                if (x == numRows - 1) {
                    direction = 1;
                    x = x - 1;
                    y = y + 1;
                } else {
                    x++;
                }
            } else {
                sbArr[x].append(cArr[i]);
                if (x == 0) {
                    direction = 0;
                    x = x + 1;
                } else {
                    x = x - 1;
                    y = y + 1;
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            sb.append(sbArr[i].toString());
        }
        return sb.toString();
    }
}

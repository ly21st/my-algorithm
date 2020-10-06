import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 *
 * https://leetcode-cn.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (43.05%)
 * Likes:    1883
 * Dislikes: 0
 * Total Accepted:    421.6K
 * Total Submissions: 979.3K
 * Testcase Example:  '"()"'
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 
 * 
 * 注意空字符串可被认为是有效字符串。
 * 
 * 示例 1:
 * 
 * 输入: "()"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: "()[]{}"
 * 输出: true
 * 
 * 
 * 示例 3:
 * 
 * 输入: "(]"
 * 输出: false
 * 
 * 
 * 示例 4:
 * 
 * 输入: "([)]"
 * 输出: false
 * 
 * 
 * 示例 5:
 * 
 * 输入: "{[]}"
 * 输出: true
 * 
 */

// @lc code=start
// 用数组模拟栈
class Solution {
    public boolean isValid(String s) {
        if (s == null) return true;
        if (s.length() == 0) return true;
        char []stack = new char[s.length()];
        char []arr = s.toCharArray();
        int i = 0;
        int []m = new int[128];
        m[')'] = '(';
        m['}'] = '{';
        m[']'] = '[';
        char a;
        for (char c : arr) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack[i++] = c;
                    break;
                case ')':
                case '}':
                case ']':
                    if (i < 1) return false;
                    a = stack[--i];
                    if (a != m[c]) return false;
                    break;
                default:
                    return false;
            }
        }
        if (i != 0) return false;
        return true;
    }
}
// @lc code=end

// 用容器stack来实现
// class Solution {
//     public boolean isValid(String s) {
//         if (s == null) return true;
//         if (s.length() == 0) return true;
//         Stack<Character> stack = new Stack<Character>();
//         char []arr = s.toCharArray();
//         char a;
//         for (char c : arr) {
//             switch (c) {
//                 case '(':
//                 case '{':
//                 case '[':
//                     stack.add(c);
//                     break;
//                 case ')':
//                     if (stack.isEmpty()) return false;
//                     a = stack.pop();
//                     if (a != '(') return false;
//                     break;
//                 case '}':
//                     if (stack.isEmpty()) return false;
//                     a = stack.pop();
//                     if (a != '{') return false;
//                     break;
//                 case ']':
//                     if (stack.isEmpty()) return false;
//                     a = stack.pop();
//                     if (a != '[') return false;
//                     break;
//             }
//         }
//         if (!stack.isEmpty()) return false;
//         return true;
//     }
// }
/*
 * @lc app=leetcode.cn id=917 lang=java
 *
 * [917] 仅仅反转字母
 */

// @lc code=start
class Solution {
    public String reverseOnlyLetters(String S) {
        int len = S.length();
        char[] s = S.toCharArray();
        for (int i = 0, j = len - 1; i < j; i++, j--) {
            while (i < j && (!Character.isLowerCase(s[i]) && !Character.isUpperCase(s[i]))) {
                i++;
            }
            while (i < j && (!Character.isLowerCase(s[j]) && !Character.isUpperCase(s[j]))) {
                j--;
            } 
            if (i < j) {
                char tmp = s[i];
                s[i] = s[j];
                s[j] = tmp;
            }
        }
        return String.valueOf(s);
    }
}
// @lc code=end



// 方法 1：字母栈
// 想法和算法
// 将 s 中的所有字母单独存入栈中，所以出栈等价于对字母反序操作。（或者，可以用数组存储字母并反序数组。）
// 然后，遍历 s 的所有字符，如果是字母我们就选择栈顶元素输出。
// JavaPythonclass Solution {
//     public String reverseOnlyLetters(String S) {
//         Stack<Character> letters = new Stack();
//         for (char c: S.toCharArray())
//             if (Character.isLetter(c))
//                 letters.push(c);

//         StringBuilder ans = new StringBuilder();
//         for (char c: S.toCharArray()) {
//             if (Character.isLetter(c))
//                 ans.append(letters.pop());
//             else
//                 ans.append(c);
//         }

//         return ans.toString();
//     }
// }


// 复杂度分析

// 时间复杂度：O(N)O(N)O(N)，其中 NNN 是 S 的长度。
// 空间复杂度：O(N)O(N)O(N)。

//  方法 2：反转指针
// 想法
// 一个接一个输出 s  的所有字符。当遇到一个字母时，我们希望找到逆序遍历字符串的下一个字母。
// 所以我们这么做：维护一个指针 j 从后往前遍历字符串，当需要字母时就使用它。
// JavaPythonclass Solution {
//     public String reverseOnlyLetters(String S) {
//         StringBuilder ans = new StringBuilder();
//         int j = S.length() - 1;
//         for (int i = 0; i < S.length(); ++i) {
//             if (Character.isLetter(S.charAt(i))) {
//                 while (!Character.isLetter(S.charAt(j)))
//                     j--;
//                 ans.append(S.charAt(j--));
//             } else {
//                 ans.append(S.charAt(i));
//             }
//         }

//         return ans.toString();
//     }
// }


// 复杂度分析

// 时间复杂度：O(N)O(N)O(N)，其中 NNN 是 S 的长度。
// 空间复杂度：O(N)O(N)O(N)。


import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 翻转字符串里的单词
 *
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/description/
 *
 * algorithms
 * Medium (42.46%)
 * Likes:    184
 * Dislikes: 0
 * Total Accepted:    74.8K
 * Total Submissions: 176.2K
 * Testcase Example:  '"the sky is blue"'
 *
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 
 * 
 * 示例 2：
 * 
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 
 * 
 * 示例 3：
 * 
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 
 * 
 * 
 * 
 * 说明：
 * 
 * 
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 
 * 
 * 
 * 
 * 进阶：
 * 
 * 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。
 * 
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        String[] arr = s.trim().split(" +");
        Collections.reverse(Arrays.asList(arr));
        return String.join(" ", arr);
    }
}
// @lc code=end


// 类似C语言方法
// class Solution {
//     public String reverseWords(String s) {
//         char []arr = s.toCharArray();
//         int len = arr.length;
//         int k = 0; 
//         int i = 0;
//         int j;
//         while (i < len && arr[i] == ' ') i++;
//         while (len > i && arr[len-1] == ' ') len--;
//         for (; i < len;) {
//             if (i == 0) {
//                 arr[k++] = arr[i++];
//                 continue;
//             }
//             if (arr[i] != ' ') {
//                 arr[k++] = arr[i++];
//                 continue;
//             }
//             if (arr[i-1] == ' ') {
//                 i++;
//             } else {
//                 arr[k++] = arr[i++];
//                 continue;
//             }
//         }
//         i = 0; 
//         j = 0;
//         while (j < k) {
//             while (j < k && arr[j] != ' ') j++;
//             reverseArr(arr, i, j);
//             j++;
//             i = j;
//         }
//         reverseArr(arr, i, j);
//         reverseArr(arr, 0, k);
//         return new String(Arrays.copyOfRange(arr, 0, k));
//     }

    
//     public void reverseArr(char []arr, int first, int end) {
//         int i = first;
//         int j = end - 1;
//         char tmp;
//         while ( i < j) {
//             tmp = arr[i];
//             arr[i] = arr[j];
//             arr[j] = tmp;
//             i++;
//             j--;
//         }
//     }
// }

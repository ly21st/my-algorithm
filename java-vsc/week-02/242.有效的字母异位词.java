import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 *
 * https://leetcode-cn.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (63.43%)
 * Likes:    326
 * Dislikes: 0
 * Total Accepted:    194K
 * Total Submissions: 305.8K
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 
 * 示例 1:
 * 
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * 
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * 
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        int []refCnt = new int[128];
        int n1 = s.length();
        int n2 = t.length();
        if (n1 != n2) {
            return false;
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return Arrays.equals(sArr, tArr);
    }
}
// @lc code=end


// 用数组方法
// class Solution {
//     public boolean isAnagram(String s, String t) {
//         int []refCnt = new int[128];
//         int n1 = s.length();
//         int n2 = t.length();
//         if (n1 != n2) {
//             return false;
//         }
//         for (int i = 0; i < n1; i++) {
//             refCnt[s.charAt(i)] += 1;
//         }
//         for (int i = 0; i < n2; i++) {
//             if (refCnt[t.charAt(i)] == 0) {
//                 return false;
//             }
//             refCnt[t.charAt(i)] -= 1;
//         }
//         return true;
//     }
// }
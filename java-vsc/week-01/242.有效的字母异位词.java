import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 *
 * https://leetcode-cn.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (61.56%)
 * Likes:    257
 * Dislikes: 0
 * Total Accepted:    143.1K
 * Total Submissions: 232.4K
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
        if (s.length() != t.length()) return false;
        char []sArr = s.toCharArray();
        char []tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return Arrays.equals(sArr, tArr);
    }
}
// @lc code=end


// 解法1，用数组代替字典
// class Solution {
//     public boolean isAnagram(String s, String t) {
//         int []arr = new int[256];

//         char []sArr = s.toCharArray();
//         char []tArr = t.toCharArray();
//         for (char c : sArr) {
//             arr[c]++;
//         }
//         for (char c : tArr) {
//             if (arr[c] <= 0) return false;
//             arr[c]--;
//         }
//         return true;
//     }
// }


// 哈希表法
// class Solution {
//     public boolean isAnagram(String s, String t) {
//         if (s.length() != t.length()) return false;
//         Map<Character, Integer> m = new HashMap<>();
        
//         char []sArr = s.toCharArray();
//         char []tArr = t.toCharArray();
//         for (char c : sArr) {
//             int v = m.getOrDefault(c, 0);
//             m.put(c, v + 1);
//         }
//         for (char c : tArr) {
//             int v = m.getOrDefault(c, 0);
//             if (v == 0) return false;
//             m.put(c, v - 1);
//         }
//         return true;
//     }
// }
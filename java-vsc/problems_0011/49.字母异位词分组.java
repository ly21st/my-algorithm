import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 *
 * https://leetcode-cn.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (61.18%)
 * Likes:    328
 * Dislikes: 0
 * Total Accepted:    67.6K
 * Total Submissions: 110.5K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 
 * 示例:
 * 
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 * 
 * 说明：
 * 
 * 
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> m = new HashMap<>();
        for (String s : strs) {
            String t = convert(s);
            List<String> list = m.getOrDefault((t), new ArrayList<String>());
            list.add(s);
            m.put(t, list);
        }
        for (List<String> v : m.values()) {
            res.add(v);
        }
        return res;
    }

    public String convert(String s) {
        char[] sArr = s.toCharArray();
        Arrays.sort(sArr);
        return new String(sArr);
    }
}
    // @lc code=end

//     public List<List<String>> groupAnagrams(String[] strs) {
//         List<List<String>> res = new ArrayList<>();
//         Map<String, List<String>> m = new HashMap<>();
//         for (String s : strs) {
//             String t = convert(s);
//             List<String> list = m.getOrDefault((t), new ArrayList<String>());
//             list.add(s);
//             m.put(t, list);
//         }
//         for (List<String> v : m.values()) {
//             res.add(v);
//         }
//         return res;
//     }

//     public String convert(String s) {
//         char[] sArr = s.toCharArray();
//         Arrays.sort(sArr);
//         return new String(sArr);
//     }

//     // public boolean isAnagrams(String s, String t) {
//     //     if (s.length() != t.length())
//     //         return false;
//     //     int n = s.length();
//     //     int[] m = new int[26];
//     //     char[] sArr = s.toCharArray();
//     //     char[] tArr = t.toCharArray();
//     //     for (char c : sArr) {
//     //         m[c - 'a']++;
//     //     }
//     //     for (char c : tArr) {
//     //         if (m[c - 'a'] <= 0)
//     //             return false;
//     //         m[c - 'a']--;
//     //     }
//     //     return true;
//     // }
// }




// 官方解法，排序数组分类
// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         if (strs.length == 0) return new ArrayList();
//         Map<String, List> ans = new HashMap<String, List>();
//         for (String s : strs) {
//             char[] ca = s.toCharArray();
//             Arrays.sort(ca);
//             String key = String.valueOf(ca);
//             if (!ans.containsKey(key)) ans.put(key, new ArrayList());
//             ans.get(key).add(s);
//         }
//         return new ArrayList(ans.values());
//     }
// }


// 官方解法，按计数分类
// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         if (strs.length == 0) return new ArrayList();
//         Map<String, List> ans = new HashMap<String, List>();
//         int[] count = new int[26];
//         for (String s : strs) {
//             Arrays.fill(count, 0);
//             for (char c : s.toCharArray()) count[c - 'a']++;

//             StringBuilder sb = new StringBuilder("");
//             for (int i = 0; i < 26; i++) {
//                 sb.append('#');
//                 sb.append(count[i]);
//             }
//             String key = sb.toString();
//             if (!ans.containsKey(key)) ans.put(key, new ArrayList());
//             ans.get(key).add(s);
//         }
//         return new ArrayList(ans.values());
//     }
// }

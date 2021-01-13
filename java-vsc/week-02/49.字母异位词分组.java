import java.util.ArrayList;
import java.util.Arrays;
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
 * Medium (65.31%)
 * Likes:    625
 * Dislikes: 0
 * Total Accepted:    157.2K
 * Total Submissions: 240.6K
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
        if (strs.length == 0) {
            return res;
        }
        Map<char[], List<String>> group = new HashMap<>();
        for (String str : strs) {
            char []arr = str.toCharArray();
            Arrays.sort(arr);
            System.out.printf("arr=%s\n", arr);
            List<String> list = group.getOrDefault(arr, new ArrayList<String>());
            list.add(str);
            group.put(arr, list);
        }
     

        for (Map.Entry<char[], List<String>> entry : group.entrySet()) {
            res.add(entry.getValue());
        }

        return res;
    }
}
// @lc code=end


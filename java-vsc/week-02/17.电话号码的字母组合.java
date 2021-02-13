/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 *
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (55.82%)
 * Likes:    1125
 * Dislikes: 0
 * Total Accepted:    219.5K
 * Total Submissions: 393.2K
 * Testcase Example:  '"23"'
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：digits = ""
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        int n = digits.length();
        if (n == 0) {
            return res;
        }
        char[] arr = digits.toCharArray();
        String[] letter = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        dfs(n, arr, res, "", letter, 0);
        return res;
    }

    public void dfs(int n, char[] arr, List<String> res, String output, 
        String[] letter, int first) {
        if (first == n) {
            res.add(output);
            return;
        }

        char c = arr[first];
        String s = letter[c - '0'];
        for (int j = 0; j < s.length(); j++) {
            dfs(n, arr, res, output + s.substring(j, j + 1), letter, 
                first + 1);
        }

    }

}
// @lc code=end

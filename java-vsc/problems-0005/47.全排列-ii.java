import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 *
 * https://leetcode-cn.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (58.03%)
 * Likes:    283
 * Dislikes: 0
 * Total Accepted:    56K
 * Total Submissions: 95.9K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,1,2]
 * 输出:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        if (len < 1) return res;
        Arrays.sort(nums);
        boolean []used = new boolean[len];
        LinkedList<Integer> list = new LinkedList<Integer>();
        helper(nums, len, list, used);
        return res;
    }
    public void helper(int[] nums, int n, LinkedList<Integer> list, boolean []used) {
        if (list.size() == n) {
            ArrayList<Integer> output = new ArrayList<Integer>(list);
            res.add(output);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            list.addLast(nums[i]);
            used[i] = true;
            helper(nums, n, list, used);
            used[i] = false;
            list.removeLast();
        }
    }
}
// @lc code=end



// 方法1
// class Solution {
//     List<List<Integer>> res = new ArrayList<List<Integer>>();
//     public List<List<Integer>> permuteUnique(int[] nums) {
//         int len = nums.length;
//         if (len < 1) return res;
//         Arrays.sort(nums);
//         boolean []used = new boolean[len];
//         LinkedList<Integer> list = new LinkedList<Integer>();
//         helper(nums, len, list, used);
//         return res;
//     }
//     public void helper(int[] nums, int n, LinkedList<Integer> list, boolean []used) {
//         if (list.size() == n) {
//             ArrayList<Integer> output = new ArrayList<Integer>(list);
//             res.add(output);
//             return;
//         }
//         for (int i = 0; i < n; i++) {
//             if (used[i]) continue;
//             if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
//             list.addLast(nums[i]);
//             used[i] = true;
//             helper(nums, n, list, used);
//             used[i] = false;
//             list.removeLast();
//         }
//     }
// }
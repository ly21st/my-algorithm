import java.awt.List;
import java.nio.file.attribute.DosFileAttributeView;
import java.util.Arrays;
import java.util.Collections;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 *
 * https://leetcode-cn.com/problems/permutations/description/
 *
 * algorithms
 * Medium (77.52%)
 * Likes:    1113
 * Dislikes: 0
 * Total Accepted:    251K
 * Total Submissions: 323.7K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,2,3]
 * 输出:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            output.add(nums[i]);
        }
        dfs(n, res, output, 0);
        return res;
    }

    public void dfs(int n, List<List<Integer>> res, List<Integer> output, int first) {
        if (first == n) {
            List<Integer> tmp = new ArrayList<>(output);
            res.add(tmp);
            return;
        }
        for (int i = first; i < n; i++) {
            Collections.swap(output, first, i);
            dfs(n, res, output, first + 1);
            Collections.swap(output, first, i);
        }
    }
}
// @lc code=end



// 深度优先算法
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer>output = new ArrayList<>();
        int n = nums.length;
        int []used = new int[n];
        dfs(n, nums, res, output, used);
        return res;
    }

    public void dfs(int n, int[] nums, List<List<Integer>> res, List<Integer> output, int []used) {
        if (output.size() >= n) {
            List<Integer> list = new ArrayList<>(output);
            res.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used[i] == 0) {
                used[i] = 1;
                output.add(nums[i]);
                dfs(n, nums, res, output, used);
                output.remove(output.size() - 1);
                used[i] = 0;
            }
        }

    }
}




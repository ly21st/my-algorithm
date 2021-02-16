import java.awt.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 *
 * https://leetcode-cn.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (62.66%)
 * Likes:    578
 * Dislikes: 0
 * Total Accepted:    135.7K
 * Total Submissions: 216.6K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * ⁠[1,2,1],
 * ⁠[2,1,1]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * -10 
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        List<Integer> output = new ArrayList<>();
        boolean []used = new boolean[n];
        Arrays.sort(nums);
        dfs(n, res, output, nums, 0, used);
        return res;
    }

    public void dfs(int n, List<List<Integer>> res, List<Integer> output, int []nums, int index, boolean[]used) {
        if (index == n) {
            List<Integer> tmp = new ArrayList<>(output);
            res.add(tmp);
            return;
        }
 
        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            output.add(nums[i]);
            dfs(n, res, output, nums, index + 1, used);
            used[i] = false;
            output.remove(output.size() - 1);
        }
    }
}
// @lc code=end



class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        List<Integer> output = new ArrayList<>();
        boolean []used = new boolean[n];
        Arrays.sort(nums);
        dfs(n, res, output, nums, used);
        return res;
    }

    public void dfs(int n, List<List<Integer>> res, List<Integer> output, int []nums, boolean[]used) {
        if (output.size() == n) {
            List<Integer> tmp = new ArrayList<>(output);
            res.add(tmp);
            return;
        }
 
        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            used[i] = true;
            output.add(nums[i]);
            dfs(n, res, output, nums, used);
            used[i] = false;
            output.remove(output.size() - 1);
        }
    }
}


// 回溯法，方法1 
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        List<Integer> output = new ArrayList<>();
        boolean []used = new boolean[n];
        dfs(n, res, output, nums, used);
        return res;
    }

    public void dfs(int n, List<List<Integer>> res, List<Integer> output, int []nums, boolean[]used) {
        if (output.size() == n) {
            List<Integer> tmp = new ArrayList<>(output);
            res.add(tmp);
            return;
        }
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            if (visited.contains(nums[i])) {
                continue;
            }
            used[i] = true;
            output.add(nums[i]);
            visited.add(nums[i]);
            dfs(n, res, output, nums, used);
            used[i] = false;
            output.remove(output.size() - 1);
        }
    }
}


// 方法2，回溯+排序
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        List<Integer> output = new ArrayList<>();
        boolean []used = new boolean[n];
        Arrays.sort(nums);
        dfs(n, res, output, nums, 0, used);
        return res;
    }

    public void dfs(int n, List<List<Integer>> res, List<Integer> output, int []nums, int index, boolean[]used) {
        if (index == n) {
            List<Integer> tmp = new ArrayList<>(output);
            res.add(tmp);
            return;
        }
 
        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]) {
                continue;
            }
            used[i] = true;
            output.add(nums[i]);
            dfs(n, res, output, nums, index + 1, used);
            used[i] = false;
            output.remove(output.size() - 1);
        }
    }
}
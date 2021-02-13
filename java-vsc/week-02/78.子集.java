import java.awt.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 *
 * https://leetcode-cn.com/problems/subsets/description/
 *
 * algorithms
 * Medium (79.50%)
 * Likes:    988
 * Dislikes: 0
 * Total Accepted:    194.3K
 * Total Submissions: 244.4K
 * Testcase Example:  '[1,2,3]'
 *
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * -10 
 * nums 中的所有元素 互不相同
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            List<Integer> output = new ArrayList<>();
            selectK(res, output, nums, n, i, 0);
        }
        return res;
    }

    // 从nums中选择k个数
    public void selectK(List<List<Integer>> res, List<Integer> output, 
        int[] nums, int n, int k, int first) {
        if (output.size() == k) {
            List<Integer> tmp = new ArrayList<Integer>(output);
            res.add(tmp);
            return;
        }
        if (first >= n) {
            return;
        }

        if (n - first < k - output.size()) {
            return;
        }
        output.add(nums[first]);
        selectK(res, output, nums, n, k, first + 1);
        output.remove(output.size() - 1);
        selectK(res, output, nums, n, k, first + 1);
    } 
}
// @lc code=end


//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res =  new ArrayList<List<Integer>>();
        int n = nums.length;
        dfs(nums, n, 0, res);
        return res;
    }

    public void dfs(int[] nums, int n, int i, List<List<Integer>> res) {
        if (i == n) {
            List<Integer> list = new ArrayList<>();
            for (int v : nums) {
                list.add(v);
            }
            res.add(list);
        }
        for (int j = i; j < n; j++) {
            if (j != i) {
                swap(nums, i, j);
            }
            dfs(nums, n, i + 1, res);
            if (i != j) {
                swap(nums, i, j);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

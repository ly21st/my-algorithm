import java.awt.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 *
 * https://leetcode-cn.com/problems/combinations/description/
 *
 * algorithms
 * Medium (73.43%)
 * Likes:    273
 * Dislikes: 0
 * Total Accepted:    51.8K
 * Total Submissions: 70.3K
 * Testcase Example:  '4\n2'
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 
 * 示例:
 * 
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> output = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int []arr = new int[n];
        for (int i = 0; i < n; i++ ) {
            arr[i] = i + 1;
        }
        helper(n, k, arr, res, output, 0);
        return res;
    }
    public void helper(int n, int k, int[] arr, List<List<Integer>> res, 
        List<Integer> output, int i){
        if (output.size() == k) {
            List<Integer> list = new ArrayList<>(output);
            res.add(list);
            return;
        }
        if (i >= n) {
            return;
        }
        for (int j = i; j < n; j++) {
            // 剪枝，当可选的剩余个数少于要填充的k个数，则提前退出
            if (n - (j - 1) < k - output.size()) {
                break;
            }
            output.add(arr[j]);
            helper(n, k, arr, res, output, j + 1);
            output.remove(output.size() - 1);
        }
    }
}
// @lc code=end


// 回溯法
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> output = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int []arr = new int[n];
        for (int i = 0; i < n; i++ ) {
            arr[i] = i + 1;
        }
        helper(n, k, arr, res, output, 0);
        return res;
    }
    public void helper(int n, int k, int[] arr, List<List<Integer>> res, 
        List<Integer> output, int i){
        if (output.size() == k) {
            List<Integer> list = new ArrayList<>(output);
            res.add(list);
            return;
        }
        if (i >= n) {
            return;
        }
        for (int j = i; j < n; j++) {
            output.add(arr[j]);
            helper(n, k, arr, res, output, j + 1);
            output.remove(output.size() - 1);
        }
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 *
 * https://leetcode-cn.com/problems/combinations/description/
 *
 * algorithms
 * Medium (76.24%)
 * Likes:    477
 * Dislikes: 0
 * Total Accepted:    130K
 * Total Submissions: 170.3K
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
        if (n - (i - 1) < k - output.size()) {
            return;
        }

        output.add(arr[i]);
        helper(n, k, arr, res, output, i + 1);
        output.remove(output.size() - 1);
        helper(n, k, arr, res, output, i + 1);
    }
}
// @lc code=end


class Solution {
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<Integer> output = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int []arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        helper(arr, n, k, res, output, 0);
        return res;
    }
    public void helper(int []arr, int n, int k, List<List<Integer>> res, ArrayList<Integer>output, int i) {
        if (output.size() >= k) {
            ArrayList<Integer> list = new ArrayList<>(output);
            res.add(list);
            return;
        }
        if (i >= n) {
            return;
        }
        for (int j = i; j < n; j++) {
            output.add(arr[j]);
            helper(arr, n, k, res, output, j + 1);
            output.remove(output.size() - 1);
        }
    }
}
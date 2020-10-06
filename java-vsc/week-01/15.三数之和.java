import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 *
 * https://leetcode-cn.com/problems/3sum/description/
 *
 * algorithms
 * Medium (29.57%)
 * Likes:    2621
 * Dislikes: 0
 * Total Accepted:    334.2K
 * Total Submissions: 1.1M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * ？请你找出所有满足条件且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 
 * 
 * 示例：
 * 
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 
 * 满足要求的三元组集合为：
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1, k = len - 1; j < k;) {
                int sum = nums[i] + nums[j] + nums[k];
                if (nums[i] + nums[j] > 0)  break;
                if (sum == 0) {
                    List<Integer> out = new ArrayList<Integer>();
                    out.add(nums[i]);
                    out.add(nums[j]);
                    out.add(nums[k]);
                    res.add(out);
                    while (j + 1 < k && nums[j + 1] == nums[j]) j++;
                    while (j < k - 1 && nums[k - 1] == nums[k]) k--;
                    j++;
                    k--;
                } else if (sum < 0) j++;
                else k--;
            }
        }
        return res;
    }
}
// @lc code=end


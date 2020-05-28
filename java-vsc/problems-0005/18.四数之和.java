import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 *
 * https://leetcode-cn.com/problems/4sum/description/
 *
 * algorithms
 * Medium (37.43%)
 * Likes:    463
 * Dislikes: 0
 * Total Accepted:    78.8K
 * Total Submissions: 209.6K
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c
 * + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 
 * 注意：
 * 
 * 答案中不可以包含重复的四元组。
 * 
 * 示例：
 * 
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 
 * 满足要求的四元组集合为：
 * [
 * ⁠ [-1,  0, 0, 1],
 * ⁠ [-2, -1, 1, 2],
 * ⁠ [-2,  0, 0, 2]
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (len < 4) return res;
        int i;
        int p1;
        int p2;
        int p3;
        Arrays.sort(nums);
        for (i = 0; i <= len - 4; i++) {
            if ( i > 0 && nums[i] == nums[i - 1]) continue;
            p1 = i + 1;
            for (p1 = i + 1; p1 <= len - 3; p1++) {
                if (p1 > i + 1 && nums[p1] == nums[p1 - 1]) continue;
                p2 = p1 + 1;
                p3 = len - 1;
                while (p2 < p3) {
                    int sum = nums[i] + nums[p1] + nums[p2] + nums[p3];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[p1]);
                        list.add(nums[p2]);
                        list.add(nums[p3]);
                        res.add(list);
                        p2++;
                        while (p2 < p3 && nums[p2] == nums[p2 - 1]) p2++;
                        p3--;
                        while (p2 < p3 && nums[p3] == nums[p3 + 1]) p3--;
                    } else if (sum < target) {
                        p2++;
                    } else {
                        p3--;
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end


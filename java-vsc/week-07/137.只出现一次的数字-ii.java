import java.util.HashSet;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=137 lang=java
 *
 * [137] 只出现一次的数字 II
 *
 * https://leetcode-cn.com/problems/single-number-ii/description/
 *
 * algorithms
 * Medium (68.60%)
 * Likes:    545
 * Dislikes: 0
 * Total Accepted:    55.3K
 * Total Submissions: 80.5K
 * Testcase Example:  '[2,2,3,2]'
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,3,2]
 * 输出: 3
 *
 *
 * 示例 2:
 *
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 *
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }
}


// @lc code=end


// 方法1
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int e : nums) {
            int count = m.getOrDefault(e, 0);
            if (count == 0) {
                m.put(e, 1);
            } else {
                m.put(e, count + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}



// 方法2
class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        long sum = 0;
        for (int e : nums) {
            sum += e;
            set.add(e);
        }
        long s1 = 0;
        for (Integer e : set) {
            s1 += e;
        }
        return (int)((s1 * 3 - sum) / 2);
    }
}


// 位移方法1
class Solution {
    public int singleNumber(int[] nums) {
        int once = 0;
        int twice = 0;
        for (int n : nums) {
            once = (once ^ n) & (~twice);
            twice = (twice ^ n) & (~once);
        }
        return once;
    }
}

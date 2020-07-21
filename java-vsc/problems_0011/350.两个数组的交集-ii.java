import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=350 lang=java
 *
 * [350] 两个数组的交集 II
 *
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/description/
 *
 * algorithms
 * Easy (47.68%)
 * Likes:    265
 * Dislikes: 0
 * Total Accepted:    79.7K
 * Total Submissions: 166.5K
 * Testcase Example:  '[1,2,2,1]\n[2,2]'
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 
 * 示例 1:
 * 
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 
 * 说明：
 * 
 * 
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 
 * 
 * 进阶:
 * 
 * 
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * 
 * 
 */

// @lc code=start
// 根据官方解法编写
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) {
            return intersect(nums2, nums1);
        }
        int []inters = new int[n1];
        Map<Integer, Integer> m = new HashMap<>();
        for (int n : nums1) {
            int count = m.getOrDefault(n, 0);
            count++;
            m.put(n, count);
        }
        
        int k = 0;
        for(int n : nums2) {
            int count = m.getOrDefault(n, 0);
            if (count > 0) {
                inters[k++] = n;
                count--;
                if (count > 0) {
                    m.put(n, count);
                } else {
                    m.remove(n);
                }
            } 
        }
        return Arrays.copyOfRange(inters, 0, k);
    }
}
// @lc code=end

// 方法1，排序法
// class Solution {
//     public int[] intersect(int[] nums1, int[] nums2) {
//         int n1 = nums1.length;
//         int n2 = nums2.length;
//         int n = n1 <= n2? n1 : n2;
//         int []res = new int[n];
//         Arrays.sort(nums1);
//         Arrays.sort(nums2);
//         int k = 0;
//         for (int i = 0, j = 0; i < n1 && j < n2; ) {
//             if (nums1[i] == nums2[j]) {
//                 res[k++] = nums1[i];
//                 i++; 
//                 j++;
//             } else if (nums1[i] < nums2[j]) {
//                 i++;
//             } else {
//                 j++;
//             }
//         }
//         return Arrays.copyOfRange(res, 0, k);
//     }
// }



// 方法2，字典法
// class Solution {
//     public int[] intersect(int[] nums1, int[] nums2) {
//         int n1 = nums1.length;
//         int n2 = nums2.length;
//         int []shortNum;
//         int []longNum;
//         Map<Integer, Integer> map = new HashMap<>();
//         if (n1 <= n2) {
//             shortNum = nums1;
//             longNum = nums2;
//         } else {
//             shortNum = nums2;
//             longNum = nums1;
//         }
//         int n = shortNum.length;
//         int []res = new int[n];
//         int k = 0;
//         for (int i = 0; i < n; i++) {
//             int v = map.getOrDefault(shortNum[i], 0);
//             map.put(shortNum[i], v + 1);
//         }
//         n = longNum.length;
//         for (int i = 0; i < n; i++) {
//             int v = map.getOrDefault(longNum[i], 0);
//             if (v > 0) {
//                 res[k++] = longNum[i];
//                 map.put(longNum[i], v - 1);
//             }
//         }
//         return Arrays.copyOfRange(res, 0, k);
//     }
// }



// 使用map，可能提前结束循环
// class Solution {
//     public int[] intersect(int[] nums1, int[] nums2) {
//         int n1 = nums1.length;
//         int n2 = nums2.length;
//         int []shortNum;
//         int []longNum;
//         Map<Integer, Integer> map = new HashMap<>();
//         if (n1 <= n2) {
//             shortNum = nums1;
//             longNum = nums2;
//         } else {
//             shortNum = nums2;
//             longNum = nums1;
//         }
//         int n = shortNum.length;
//         int []res = new int[n];
//         int k = 0;
//         for (int i = 0; i < n; i++) {
//             int v = map.getOrDefault(shortNum[i], 0);
//             map.put(shortNum[i], v + 1);
//         }
//         n = longNum.length;
//         for (int i = 0; i < n; i++) {
//             int v = map.getOrDefault(longNum[i], 0);
//             if (v > 1) {
//                 res[k++] = longNum[i];
//                 map.put(longNum[i], v - 1);
//             } else if (v == 1) {
//                 res[k++] = longNum[i];
//                 map.remove(longNum[i]);
//             }
//             if (map.size() == 0) {
//                 break;
//             }
//         }
//         return Arrays.copyOfRange(res, 0, k);
//     }
// }
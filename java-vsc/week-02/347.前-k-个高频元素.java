import java.util.*;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 *
 * https://leetcode-cn.com/problems/top-k-frequent-elements/description/
 *
 * algorithms
 * Medium (61.82%)
 * Likes:    604
 * Dislikes: 0
 * Total Accepted:    124.5K
 * Total Submissions: 201.3K
 * Testcase Example:  '[1,1,1,2,2,3]\n2'
 *
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int count = m.getOrDefault(nums[i], 0);
            count++;
            m.put(nums[i], count);
        }
        int []countArr = new int[m.size()];
        int i = 0;
        Map<Integer, List<Integer>> mReverse = new HashMap<>();
        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            List<Integer> li = mReverse.getOrDefault(e.getValue(), new ArrayList<Integer>());
            li.add(e.getKey());
            mReverse.put(e.getValue(), li);
            countArr[i++] = e.getValue();
        }
        
        // 获取频率最高的k个数
        int []kFrequent = kMax(countArr, k);
        int []res = new int[k];
        i = 0;
        int count = 0;
        Set<Integer> visited = new HashSet<>();
        while (count < k) {
            List<Integer> li = mReverse.get(kFrequent[i]);
            int left = Math.min(k - count, li.size());
            for (int j = 0; j < left; j++) {
                int v = li.get(j);
                if (!visited.contains(v)) {
                    res[count++] = v;
                    visited.add(v);
                }
            }
            i++;
        }
        
        return res;
    }

    public static int[] kMax(int []nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); 
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        int n = nums.length;
        for (int i = k; i < n; i++ ) {
            int v = pq.peek();
            if (nums[i] > v) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
        int []res = new int[k];
        int i = 0;
        Iterator<Integer> iterator = pq.iterator();
        while (iterator.hasNext()) {
            res[i++] = iterator.next();
        }
        return res;
    }
}
// @lc code=end


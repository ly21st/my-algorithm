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
            m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
        }
        int []res = new int[k];
        int [][]refCnt = new int[m.size()][2];
        int [][]merge= new int[k][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            refCnt[i++] = new int[]{entry.getKey(), entry.getValue()};
        }

        margeArr(refCnt, 0, refCnt.length - 1, k, merge, 0);
        for (i = 0; i < k; i++) {
            res[i] = merge[i][0];
        }
        return res;

    }

    //
    public void margeArr(int [][]nums, int begin, int end, int k, int [][]merge, int t) {
        if (end <= begin) {
            merge[t++] = nums[begin];
            return;
        }
        int pivot = partition(nums, begin, end);
        if ((pivot - begin) <= k) {
            for (int i = begin; i < pivot; i++) {
                merge[t++] = nums[i];
            }
            int count = pivot - begin;
            if (count < k) {
                merge[t++] = nums[pivot];
                margeArr(nums, pivot + 1, end, k - count - 1, merge, t);
            }
        } else{
            margeArr(nums, begin, pivot - 1, k, merge, t);
        }
    }

    // 快速排序分区，最简洁的实现方法
    public int partition(int [][]nums, int begin, int end) {
        int pivot = end;
        int count = begin;
        for (int i = begin; i < end; i++) {
            if (nums[i][1] > nums[pivot][1]) {
                int []tmp = nums[count];
                nums[count] = nums[i];
                nums[i] = tmp;
                count++;
            }
        }
        int []tmp = nums[count];
        nums[count] = nums[pivot];
        nums[pivot] = tmp;
        return count;
    }
}
// @lc code=end


/**
 *  方法1
 */

// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         Map<Integer, Integer> m = new HashMap<>();
//         int n = nums.length;
//         for (int i = 0; i < n; i++) {
//             int count = m.getOrDefault(nums[i], 0);
//             count++;
//             m.put(nums[i], count);
//         }
//         int []countArr = new int[m.size()];
//         int i = 0;
//         Map<Integer, List<Integer>> mReverse = new HashMap<>();
//         for (Map.Entry<Integer, Integer> e : m.entrySet()) {
//             List<Integer> li = mReverse.getOrDefault(e.getValue(), new ArrayList<Integer>());
//             li.add(e.getKey());
//             mReverse.put(e.getValue(), li);
//             countArr[i++] = e.getValue();
//         }
        
//         // 获取频率最高的k个数
//         int []kFrequent = kMax(countArr, k);
//         int []res = new int[k];
//         i = 0;
//         int count = 0;
//         Set<Integer> visited = new HashSet<>();
//         while (count < k) {
//             List<Integer> li = mReverse.get(kFrequent[i]);
//             int left = Math.min(k - count, li.size());
//             for (int j = 0; j < left; j++) {
//                 int v = li.get(j);
//                 if (!visited.contains(v)) {
//                     res[count++] = v;
//                     visited.add(v);
//                 }
//             }
//             i++;
//         }
        
//         return res;
//     }

//     public static int[] kMax(int []nums, int k) {
//         PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); 
//         for (int i = 0; i < k; i++) {
//             pq.add(nums[i]);
//         }
//         int n = nums.length;
//         for (int i = k; i < n; i++ ) {
//             int v = pq.peek();
//             if (nums[i] > v) {
//                 pq.poll();
//                 pq.add(nums[i]);
//             }
//         }
//         int []res = new int[k];
//         int i = 0;
//         Iterator<Integer> iterator = pq.iterator();
//         while (iterator.hasNext()) {
//             res[i++] = iterator.next();
//         }
//         return res;
//     }
// }



// 方法2
// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         Map<Integer, Integer> m = new HashMap<>();
//         int n = nums.length;
//         for (int i = 0; i < n; i++) {
//             m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
//         }
//         int []res = new int[k];
//         PriorityQueue<int[]> refCnt = new PriorityQueue<>((int[]o1, int o2[]) -> {
//             return o1[1] - o2[1];
//         });
//         for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
//             int num = entry.getKey();
//             int count = entry.getValue();
//             if (refCnt.size() < k) {
//                 refCnt.add(new int[]{num, count});
//                 continue;
//             }
//             int []v = refCnt.peek();
//             if (v[1] < count) {
//                 refCnt.poll();
//                 refCnt.add(new int[]{num, count});
//             }
//         }
//         for (int i = 0; i < k; i++) {
//             res[i] = refCnt.poll()[0];
//         }

//         return res;
//     }
// }
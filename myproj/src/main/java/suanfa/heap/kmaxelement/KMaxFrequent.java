package suanfa.heap.kmaxelement;

import java.util.HashMap;
import java.util.Map;

public class KMaxFrequent {
    public static void main(String []args) {
//        int []nums = {1,1,1,2,2,3};
//        int k = 2;

//        int []nums = {1};
//        int k = 1;

//        int []nums = {5,3,1,1,1,3,73,1};
//        int k = 2;

//        int []nums = {5,2,5,3,5,3,1,1,3};
//        int k = 2;

        int []nums = {1,2};
        int k = 2;

        KMaxFrequent kMaxFrequent = new KMaxFrequent();
        int []res = kMaxFrequent.topKFrequent(nums, k);
        for (int i = 0; i < res.length; i++) {
            System.out.printf("%d ", res[i]);
        }
        System.out.println();
    }


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

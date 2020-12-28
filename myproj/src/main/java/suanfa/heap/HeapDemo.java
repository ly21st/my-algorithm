package suanfa.heap;

import java.util.PriorityQueue;

/**
 * PriorityQueue容器使用例子
 */
public class HeapDemo {

    public static void main(String[] args) {
        int []arr = {10, 60, 70, 40, 30, 50, 90, 80, 20, 100};
        prioritySort(arr);
    }

    public static void prioritySort(int []nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int n : nums) {
            queue.add(n);
        }

        while (!queue.isEmpty()) {
            System.out.printf("%d ", queue.remove());
        }
    }
    
}

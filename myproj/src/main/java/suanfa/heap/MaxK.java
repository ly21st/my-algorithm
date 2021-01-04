package suanfa.heap;

import java.util.*;

/**
 * @description:查找最大的k个元素，
 * 有几种方法：参考https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
 * 方法1：桶排序
 * 方法2：额外k大小的数组
 * 方法3：先排序，再取k个元素
 * 方法4：对n个数构造最大堆，然后提取k次
 * 方法5：使用有序统计
 * 方法6：使用最小堆
 *
 *
 * @author: LiYuan
 * @version: 1.0
 * @create: 2021-01-01
 **/
public class MaxK {

    public static void main(String[] args)
    {
        method1();
        method2();
        method3();
    }

    public static void method1() {
        Integer []arr = new Integer[] { 1, 23, 12, 9,
                30, 2, 50 };
        int k = 3;
        Integer []res = kLargest(arr, k);
        printArr(res);
    }

    public static Integer[] kLargest(Integer []arr, int k) {
        if (k >= arr.length) {
            return arr;
        }
        Integer []kArr = new Integer[k];
        for (int i = 0; i < k; i++) {
            kArr[i] = arr[i];
        }
        int len = arr.length;
        for (int i = k; i < len; i++ ) {
            int minIndex = findMin(kArr);
            if (arr[i] > kArr[minIndex]) {
                int tmp = kArr[minIndex];
                kArr[minIndex] = arr[i];
                arr[i] = tmp;
            }
        }
        return kArr;
    }

    public static int findMin(Integer []arr) {
        if (arr.length == 0) {
            return 0;
        }
        int min = arr[0];
        int minIndex = 0;
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void printArr(Integer[] arr) {
        for (int n : arr) {
            System.out.printf("%d ", n);
        }
        System.out.println();
        System.out.println();
    }


    public static void method2() {
        Integer []arr = new Integer[] { 1, 23, 12, 9,
                30, 2, 50 };
        int k = 3;

//        Arrays.sort(arr, new NumSort());
        Arrays.sort(arr, Collections.reverseOrder());
        Integer []res = Arrays.copyOf(arr, k);
        printArr(res);
    }

    public static void method3() {
        Integer []arr = new Integer[] { 1, 23, 12, 9,
                30, 2, 50 };
        int k = 3;

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            int min = pq.peek();
            if (arr[i] > min) {
                pq.poll();
                pq.add(arr[i]);
            }
        }

//        while (!pq.isEmpty()) {
//            System.out.printf("%d ", pq.poll());
//        }
        Iterator iterator = pq.iterator();

        while (iterator.hasNext())
        {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }


}

class NumSort implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}
package suanfa.week08.sortDemo;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2021-03-03
 **/
@Slf4j
public class HeapDemo {
    public static void main(String[] args) {
        int[] arr = {30, 60, 10, 50, 90, 70, 40, 20, 80, 100, 60, 40};
        sort(arr);
        log.info("arr:{}", arr);
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        makeHeap(arr, n);
        for (int i = n - 1; i >= 1; i--) {
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            heapify(arr, i, 0);
        }
    }

    public static void heapify(int []arr, int n, int root) {
        int left;
        int right;
        int maxIndex = root;
        int max = arr[root];
        left = 2 * root + 1;
        if (left < n && arr[left] > max) {
            maxIndex = left;
            max = arr[left];
        }
        right = 2 * root + 2;
        if (right < n && arr[right] > max) {
            maxIndex = right;
        }
        if (maxIndex != root) {
            int tmp = arr[root];
            arr[root] = arr[maxIndex];
            arr[maxIndex] = tmp;
            heapify(arr, n, maxIndex);
        }
    }

    public static void makeHeap(int[] arr, int n) {
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }
}

package suanfa.week08.sortDemo;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2021-03-01
 **/
@Slf4j
public class QuickDemo {
    public static void main(String[] args) {
        int[] arr = {30, 60, 10, 50, 90, 70, 40, 20, 80, 100, 60, 40};
        sort(arr, 0, arr.length - 1);
        log.info("arr:{}", arr);
    }

    public static int quickSort(int []arr, int start, int end) {
        int count = start;
        int v = arr[end];
        for (int i = start; i < end; i++) {
            if (arr[i] < v) {
                int tmp = arr[i];
                arr[i] = arr[count];
                arr[count] = tmp;
                count++;
            }
        }
        int tmp = arr[count];
        arr[count] = v;
        arr[end] = tmp;
        return count;
    }

    public static void sort(int[] arr, int start, int end) {
        if (end <= start) {
            return;
        }
        int mid = quickSort(arr, start, end);
        sort(arr, start, mid - 1);
        sort(arr, mid + 1, end);
    }
}

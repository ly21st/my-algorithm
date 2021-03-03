package suanfa.week08.sortDemo;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2021-03-03
 **/
@Slf4j
public class MergeDemo {
    public static void main(String[] args) {
        int[] arr = {30, 60, 10, 50, 90, 70, 40, 20, 80, 100, 60, 40};
        sort(arr);
        log.info("arr:{}", arr);
    }

    public static void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int []arr, int start, int end) {
        if (end  <= start) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }


    public static void merge(int[] arr, int start, int mid, int end) {
        int []res = new int[end - start + 1];
        int i, j;
        int k = 0;
        for (i = start, j = mid + 1; i <= mid && j <= end; ) {
            res[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            res[k++] = arr[i++];
        }
        while (j <= end) {
            res[k++] = arr[j++];
        }
        k = 0;
        for (i = start; i <= end;) {
            arr[i++] = res[k++];
        }
    }
}

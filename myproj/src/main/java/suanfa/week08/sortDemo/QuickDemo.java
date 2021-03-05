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

    public static int quickSort(int[] arr, int start, int end) {
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


    // 方法2
//    public static void merge_sort(int a[], int first, int last, int temp[]) {
//
//        if (first < last) {
//            int middle = (first + last) / 2;
//            merge_sort(a, first, middle, temp);//左半部分排好序
//            merge_sort(a, middle + 1, last, temp);//右半部分排好序
//            mergeArray(a, first, middle, last, temp); //合并左右部分
//        }
//    }
//
//    //合并 ：将两个序列a[first-middle],a[middle+1-end]合并
//    public static void mergeArray(int a[], int first, int middle, int end, int temp[]) {
//        int i = first;
//        int m = middle;
//        int j = middle + 1;
//        int n = end;
//        int k = 0;
//        while (i <= m && j <= n) {
//            if (a[i] <= a[j]) {
//                temp[k] = a[i];
//                k++;
//                i++;
//            } else {
//                temp[k] = a[j];
//                k++;
//                j++;
//            }
//        }
//        while (i <= m) {
//            temp[k] = a[i];
//            k++;
//            i++;
//        }
//        while (j <= n) {
//            temp[k] = a[j];
//            k++;
//            j++;
//        }
//
//        for (int ii = 0; ii < k; ii++) {
//            a[first + ii] = temp[ii];
//        }
//    }
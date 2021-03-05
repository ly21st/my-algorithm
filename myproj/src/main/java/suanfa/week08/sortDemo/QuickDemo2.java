package suanfa.week08.sortDemo;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2021-03-01
 **/
@Slf4j
public class QuickDemo2 {
    public static void main(String[] args) {
        int[] arr = {30, 60, 10, 50, 90, 70, 40, 20, 80, 100, 60, 40};
        sort(arr, 0, arr.length - 1);
        log.info("arr:{}", arr);
    }

    public static void sort(int []arr, int start, int end) {
        if (end <= start) {
            return;
        }
        int mid = quickSort(arr, start, end);
        sort(arr, start, mid - 1);
        sort(arr, mid + 1, end);
    }

//    public static int quickSort(int[]arr, int start, int end) {
//        int count = start;
//        int v = arr[end];
//        for (int i = start; i < end; i++) {
//            if (arr[i] < v) {
//                int tmp = arr[i];
//                arr[i] = arr[count];
//                arr[count] = tmp;
//                count++;
//            }
//        }
//        int tmp = arr[count];
//        arr[count] = v;
//        arr[end] = tmp;
//        return count;
//    }

    public static int quickSort(int []arr, int start, int end) {
        int i = start;
        int j = end;
        int v = arr[i];
        while (i < j) {
            while (i < j && arr[j] >= v) {
                j--;
            }
            swap(arr, i, j);
            while (i < j && arr[i] < v) {
                i++;
            }
            swap(arr, i, j);
        }
        return j;
    }

    public static void swap(int[]arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}


// 方法2
//public static void quickSort(int a[],int l,int r){
//    if(l>=r)
//        return;
//
//    int i = l; int j = r; int key = a[l];//选择第一个数为key
//
//    while(i<j){
//
//        while(i<j && a[j]>=key)//从右向左找第一个小于key的值
//            j--;
//        if(i<j){
//            a[i] = a[j];
//            i++;
//        }
//
//        while(i<j && a[i]<key)//从左向右找第一个大于key的值
//            i++;
//
//        if(i<j){
//            a[j] = a[i];
//            j--;
//        }
//    }
//    //i == j
//    a[i] = key;
//    quickSort(a, l, i-1);//递归调用
//    quickSort(a, i+1, r);//递归调用
//}
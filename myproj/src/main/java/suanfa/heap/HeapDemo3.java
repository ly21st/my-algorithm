package suanfa.heap;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2021-01-01
 **/
public class HeapDemo3 {
    public static void main(String[] args) {
        int[] arr = {10, 60, 70, 40, 30, 30, 50, 90, 80, 80, 20, 100};
        heapSort(arr, arr.length);

        reverse(arr);
        for (int n : arr) {
            System.out.printf("%d ", n);
        }
    }

    public static void reverse(int[] arr) {
        int len = arr.length;
        for (int i= 0, j = len - 1; i < j; i++, j--) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    public static void heapSort(int []arr, int n) {
        makeHeap(arr, n);
        for (int i = n - 1; i > 0; i--) {
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            heapAdjust(arr, 0, i);
        }
    }

    public static void makeHeap(int []arr, int n) {
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapAdjust(arr, i, n);
        }
    }

    public static void heapAdjust(int []arr, int root, int n) {
        int left = root * 2 + 1;
        int right = root * 2 + 2;
        int minIndex = root;
        int min = arr[minIndex];
        if ((right < n) && (arr[right] < min)) {
            minIndex = right;
            min = arr[right];
        }
        if ((left < n) && (arr[left] < min)) {
            minIndex = left;
            min = arr[left];
        }
        if (minIndex != root) {
            int tmp = arr[root];
            arr[root] = min;
            arr[minIndex] = tmp;
            heapAdjust(arr, minIndex, n);
        }
    }
}

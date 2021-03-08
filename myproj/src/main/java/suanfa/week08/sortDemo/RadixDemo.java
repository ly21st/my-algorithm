package suanfa.week08.sortDemo;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2021-03-08
 **/
@Slf4j
public class RadixDemo {
    public static void main(String[] args) {
        int[] arr = {30, 60, 10, 50, 90, 70, 40, 20, 80, 100, 60, 40};
        sort(arr);
        log.info("arr:{}", arr);
    }

    public static void sort(int[] arr) {
        int []tmp = new int[arr.length];
        int []cnt = new int[10];
        radixSort(arr, tmp, arr.length, 3, 10, cnt);
    }

    public static void radixSort(int[] arr, int []tmp, int n, int k, int r, int[] cnt) {
        int radixK = 1;

        // 每一维度排序
        for (int radix = 0; radix < k; radix++) {
            // 每一个维度排序前，计数器要重新初始化为0
            for (int i = 0; i < r; i++) {
                cnt[i] = 0;
            }

            for (int i = 0; i < n; i++) {
                int tail = (arr[i] / radixK) % r;
                cnt[tail] ++;
            }
            for (int i = 1; i < r; i++) {
                cnt[i] = cnt[i - 1] + cnt[i];
            }
            for (int i = n  - 1; i >= 0; i--) {
                int tail = (arr[i] / radixK) % r;
                cnt[tail]--;
                tmp[cnt[tail]] = arr[i];
            }
            for (int i = 0; i < n; i++) {
                arr[i] = tmp[i];
            }

            radixK = radixK * r;
        }
    }
}

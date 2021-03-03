package suanfa.week08.sortDemo;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2021-03-01
 **/
@Slf4j
public class BubbleDemo {
        public static void main(String[] args) {
            int[] arr = {30, 60, 10, 50, 90, 70, 40, 20, 80, 100, 60, 40};
//        bubble(arr);
            bubble2(arr);
            log.info("arr:{}", arr);
        }

    public static void bubble(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = n - 1; j >= i; j--) {
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }
    }

    public static void bubble2(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}

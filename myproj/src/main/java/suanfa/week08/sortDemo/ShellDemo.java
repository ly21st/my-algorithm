package suanfa.week08.sortDemo;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2021-03-03
 **/
@Slf4j
public class ShellDemo {
    public static void main(String[] args) {
        int[] arr = {30, 60, 10, 50, 90, 70, 40, 20, 80, 100, 60, 40};
        sort(arr);
        log.info("arr:{}", arr);
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        int factor = n / 2;
        while (factor > 0) {
            for (int i = 0; i < factor; i++) {
                for (int j = i + factor; j < n; j += factor) {
                    int tmp = arr[j];
                    int k;
                    for (k = j - factor; k >= 0; k -= factor) {
                        if (arr[k] > tmp) {
                            arr[k + factor] = arr[k];
                        } else {
                            break;
                        }
                    }

                    arr[k + factor] = tmp;
                }
            }
            factor /= 2;
        }
    }
}

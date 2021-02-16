package suanfa.week04;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2021-02-15
 **/
@Slf4j
public class CoinsCount {
    int minCount = -1;
    boolean found = false;

    public static void main(String[] args) {
        CoinsCount coinsCount = new CoinsCount();
        int []coins = {186,419,83,408};
        int amount = 6249;
        int res = coinsCount.coinChange(coins, amount);
        log.info("res:{}", res);
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        reverse(coins);
        int n = coins.length;
        helper(coins, n, amount, 0, 0);
        return minCount;
    }

    public void helper(int[] coins, int n, int amount, int level, int count) {
        if (level == n) {
            return;
        }
        if (found) {
            return;
        }
        int m = amount / coins[level];
        if ( amount % coins[level] == 0) {
            count += m;
            minCount = count;
            found = true;
            return;
        }
        for (int i = m; i >= 0; i--) {
            count += i;
            helper(coins, n, amount - coins[level] * i, level + 1, count);
            count -= i;
        }
    }

    public void reverse(int []arr) {
        int n = arr.length;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}

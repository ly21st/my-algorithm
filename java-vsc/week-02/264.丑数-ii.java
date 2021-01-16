import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 *
 * https://leetcode-cn.com/problems/ugly-number-ii/description/
 *
 * algorithms
 * Medium (54.26%)
 * Likes:    407
 * Dislikes: 0
 * Total Accepted:    36.9K
 * Total Submissions: 67.9K
 * Testcase Example:  '10'
 *
 * 编写一个程序，找出第 n 个丑数。
 * 
 * 丑数就是质因数只包含 2, 3, 5 的正整数。
 * 
 * 示例:
 * 
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 
 * 说明:  
 * 
 * 
 * 1 是丑数。
 * n 不超过1690。
 * 
 * 
 */

// @lc code=start
// 使用最小堆的方法
public class Ugly {
    static int maxN = 1690;
    int[] uglyArr = new int[maxN];
    Set<Long> visited = new HashSet<>();

    public Ugly () {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(1L);
        int i = 1;
        while (i <= maxN) {
            long top = pq.poll();
            uglyArr[i - 1] = (int)top;
            i++;
            if (!visited.contains(top * 2)) {
                pq.add(top * 2);
                visited.add(top * 2);
            }
            if (!visited.contains(top * 3)) {
                pq.add(top * 3);
                visited.add(top * 3);
            }
            if (!visited.contains(top * 5)) {
                pq.add(top * 5);
                visited.add(top * 5);
            }
        }
    }

}

class Solution {
    static Ugly ugly = new Ugly();
    public int nthUglyNumber(int n) {
        return ugly.uglyArr[n - 1];
    }
}
// @lc code=end



// 暴力法
class Solution {
    public int nthUglyNumber(int n) {
        Set<Integer> set = new HashSet<>();
        if (n <= 6) return n; 
        for (int i = 1; i <= 6; i++) {
            set.add(i);
        }
        int i = 6; 
        int count = 6;
        while (count < n) {
            i++;
            if (isUglyNumber(i, set)) {
                set.add(i);
                count++;
            } 
        }
        return i;
    }

    public boolean isUglyNumber(int i, Set<Integer> set) {
        int j;
        j = i / 2;
        if (i % 2 == 0 && set.contains(j)) {
            return true;
        }
        j = i / 3;
        if (i % 3 == 0 && set.contains(j)) {
            return true;
        }
        j = i / 5;
        if (i % 5 == 0 && set.contains(j)) {
            return true;
        }
        return false;
    }
}


// 使用优先级堆
class Solution {
    static int []res = new int[1690];
    public int nthUglyNumber(int n) {
        int []arr = {2, 3, 5};
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        heap.add(1L);
        set.add(1L);
        for (int i = 0; i < 1690; i++) {
            long a = heap.poll();
            res[i] = (int)a;
            for (int j = 0; j < arr.length; j++) {
                long k = a * arr[j];
                if (!set.contains(k)) {
                    set.add(k);
                    heap.add(k);
                }
            }
        }
        return res[n - 1];
    }
}


// p2表示使用过2因子的最大索引，p3表示使用过3因子的最大索引，p5表示使用过5因子的最大索引，
// 使用因子3，那么因子2已经使用过了；使用因子5，那么因子2,3已经使用过了。
class Ugly {
    static int []res = new int[1690];
    public Ugly() {
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        res[0] = 1;
        for (int i = 1; i < 1690; i++) {
            int min = Math.min(Math.min(res[p2] * 2, res[p3] * 3), res[p5] * 5);
            res[i] = min;
            if (min == res[p2] * 2) {
                p2++;
            }
            if (min == res[p3] * 3) {
                p3++;
            }
            if (min == res[p5] * 5) {
                p5++;
            }
        }
    }
}

class Solution {
    static Ugly ugly = new Ugly();
    public int nthUglyNumber(int n) {
        return ugly.res[n - 1];
    }
}
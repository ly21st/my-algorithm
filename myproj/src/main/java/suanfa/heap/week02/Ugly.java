package suanfa.heap.week02;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2021-01-15
 **/
public class Ugly {
    static int maxN = 1690;
    static int[] uglyArr = new int[maxN];
    static Set<Long> visited = new HashSet<>();
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
    public int nthUglyNumber(int n) {
        for (int num : uglyArr) {
            System.out.printf("%d ", num);
        }
        System.out.println();
        return uglyArr[n - 1];
    }

    public static void main(String []argc) {
        Ugly ugly = new Ugly();
        int n = ugly.nthUglyNumber(10);
        System.out.println(n);
    }

}

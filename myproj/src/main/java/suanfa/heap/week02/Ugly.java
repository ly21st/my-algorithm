package suanfa.heap.week02;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2021-01-15
 **/
public class Ugly {
    static int maxN = 1690;
    int[] uglyArr = new int[maxN];

    public Ugly () {
        uglyArr[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        int i = 1;
        while (i < maxN) {
            long min = Math.min(Math.min((long)uglyArr[p2] * 2, (long)uglyArr[p3] * 3), (long)uglyArr[p5] * 5);
            if (min == (long)uglyArr[p2] * 2) {
                p2++;
            }
            if (min == (long)uglyArr[p3] * 3) {
                p3++;
            }
            if (min == (long)uglyArr[p5] * 5) {
                p5++;
            }
            uglyArr[i++] = (int)min;
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

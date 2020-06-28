/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 朋友圈
 *
 * https://leetcode-cn.com/problems/friend-circles/description/
 *
 * algorithms
 * Medium (56.74%)
 * Likes:    260
 * Dislikes: 0
 * Total Accepted:    48.9K
 * Total Submissions: 85.6K
 * Testcase Example:  '[[1,1,0],[1,1,0],[0,0,1]]'
 *
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是
 * C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 * 
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j
 * 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 * 
 * 示例 1:
 * 
 * 
 * 输入: 
 * [[1,1,0],
 * ⁠[1,1,0],
 * ⁠[0,0,1]]
 * 输出: 2 
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回2。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: 
 * [[1,1,0],
 * ⁠[1,1,1],
 * ⁠[0,1,1]]
 * 输出: 1
 * 说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
 * 
 * 
 * 注意：
 * 
 * 
 * N 在[1,200]的范围内。
 * 对于所有学生，有M[i][i] = 1。
 * 如果有M[i][j] = 1，则有M[j][i] = 1。
 * 
 * 
 */

// @lc code=start
// 并查集方法
class Solution {
    int count = 0;
    int []parent;

    public int findCircleNum(int[][] M) {
        int m = M.length;
        if (m < 1) {
            return 0;
        }
        int n = M[0].length;
        if (n < 1) {
            return 0;
        }
        parent = new int[m];
        for (int i = 0; i < m; i++) {
            parent[i] = -1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= i; j++) {
                if (M[i][j] == 1 && i != j) {
                    unionFind(parent, i, j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (parent[i] == -1) {
                count++;
            }
        }
        return count;
    }

    public int find(int[] parent, int p) {
        while (parent[p] != -1) {
            p = parent[p];
        }
        return p;
    }

    public void unionFind(int[] parent, int p, int q) {
        p = find(parent, p);
        q = find(parent, q);
        if (p != q) {
            parent[p] = q;
        }
    }

}
// @lc code=end


// 类似孤岛问题方法
// class Solution {
//     int count = 0;

//     public int findCircleNum(int[][] M) {
//         int m = M.length;
//         if (m < 1) {
//             return 0;
//         }
//         int n = M[0].length;
//         if (n < 1) {
//             return 0;
//         }
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (M[i][j] == 1) {
//                     circleNumCount(M, m, n, i, j);
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }

//     public void circleNumCount(int[][] M, int m, int n, int i, int j) {
//         M[i][j] = 0;
//         M[j][i] = 0;
//         M[i][i] = 0;
//         M[j][j] = 0;
//         for (int k = 0; k < m; k++) {
//             if (M[i][k] == 1) {
//                 M[i][k] = 0;
//                 circleNumCount(M, m, n, i, k);
//             }
//         }
//         for (int k = 0; k < n; k++) {
//             if (M[j][k] == 1) {
//                 M[j][k] = 0;
//                 circleNumCount(M, m, n, j, k);
//             }
//         }
//     }
// }


// 回溯法优化
// class Solution {
//     int count = 0;

//     public int findCircleNum(int[][] M) {
//         int m = M.length;
//         if (m < 1) {
//             return 0;
//         }
//         int n = M[0].length;
//         if (n < 1) {
//             return 0;
//         }
//         for (int i = 0; i < m; i++) {
//             if (circleNumCount(M, n, i)) {
//                 count++;
//             }
//         }
//         return count;
//     }

//     public boolean circleNumCount(int[][] M, int n, int i) {
//         boolean has = false;
//         for (int j = 0; j < n; j++) {
//             if (M[i][j] == 1) {
//                 has = true;
//                 M[i][j] = 0;
//                 circleNumCount(M, n, j);
//             }
//         }
//         return has;
//     }
// }




// 深度优先算法，官方代码收藏
// public class Solution {
//     public void dfs(int[][] M, int[] visited, int i) {
//         for (int j = 0; j < M.length; j++) {
//             if (M[i][j] == 1 && visited[j] == 0) {
//                 visited[j] = 1;
//                 dfs(M, visited, j);
//             }
//         }
//     }
//     public int findCircleNum(int[][] M) {
//         int[] visited = new int[M.length];
//         int count = 0;
//         for (int i = 0; i < M.length; i++) {
//             if (visited[i] == 0) {
//                 dfs(M, visited, i);
//                 count++;
//             }
//         }
//         return count;
//     }
// }


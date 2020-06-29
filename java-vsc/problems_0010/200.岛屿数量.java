/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 *
 * https://leetcode-cn.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (49.51%)
 * Likes:    624
 * Dislikes: 0
 * Total Accepted:    121K
 * Total Submissions: 243.8K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 * 
 * 此外，你可以假设该网格的四条边均被水包围。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 * 
 * 
 */

// @lc code=start
// 并查集方法，性能不是很好
class Solution {
    class UnionFound {                                                  
        private int count;                                              
        private int []parent;                                           
        private int []size;                                             
        public UnionFound(int n) {                                      
            count = n;                                                  
            parent = new int[n];                                        
            size = new int[n];                                          
            for (int i = 0; i < n; i++) {                               
                parent[i] = i;                                          
            }                                                           
        }                                                               
                                                                        
        public int find(int []parent, int p) {                          
             while (p != parent[p]) {                                   
                 parent[p] = parent[parent[p]];                         
                 p = parent[p];                                         
             }                                                          
             return p;                                                  
        }                                                               
                                                                        
       public void union(int p, int q) {                                
            int setp =  find(parent, p);                                
            int setq = find(parent, q);                                 
            if (setp == setq) {                                         
                return;                                                 
            }                                                           
            count--;                                                    
            if (size[setp] < size[setq]) {                              
                parent[setp] = setq;                                    
                size[setq] += size[setp];                               
            } else {                                                    
                parent[setq] = setp;                                    
                size[setq] += size[setp];                               
            }                                                           
       }                                                                
                                                                        
       public int count() {                                             
            return count;                                               
       }                                                                
    }                                                                   
                                                                        
    public int numIslands(char[][] grid) {                              
        int m = grid.length;                                            
        if (m < 1) {                                                    
            return 0;                                                   
        }                                                               
        int n = grid[0].length;                                         
        if (n < 1) {                                                    
            return 0;                                                   
        }                                                               
        UnionFound uf = new UnionFound(m * n);   
        int count = 0;                       
        for (int i = 0; i < m; i++) {                                   
            for (int j = 0; j < n; j++) {                               
                if (grid[i][j] == '1') { 
                    grid[i][j] = '0';
                    count++;                               
                    int p = i * n + j;                                  
                    if (i > 0 && grid[i - 1][j] == '1') {               
                        uf.union(p, (i - 1) * n + j);                   
                    }                                                   
                    if (j > 0 && grid[i][j - 1] == '1') {               
                        uf.union(p, i * n + j - 1);                     
                    }                                                   
                    if (i < m - 1 && grid[i + 1][j] == '1') {           
                        uf.union(p, (i + 1) * n + j);                   
                    }                                                   
                    if (j < n - 1 && grid[i][j + 1] == '1') {           
                        uf.union(p, i * n + j + 1);                     
                    }                                                   
                }                                                       
            }                                                           
        }                                                               
        return count - (m * n - uf.count());                                              
    }                                                                                                                                                          
}
// @lc code=end


// 深度优先遍历算法
// class Solution {
//     public int numIslands(char[][] grid) {                             
//         int m = grid.length;                                           
//         if (m < 1) {                                                   
//             return 0;                                                  
//         }                                                              
//         int n = grid[0].length;                                        
//         if (n < 1) {                                                   
//             return 0;                                                  
//         }                                                              
//         int count = 0;                                                 
//         for (int i = 0; i < m; i++) {                                  
//             for (int j = 0; j < n; j++) {                              
//                 if (grid[i][j] == '1') {                               
//                     count++;                                           
//                     dfs(grid, m, n, i, j);                             
//                 }                                                      
//             }                                                          
//         }                                                              
//         return count;                                                  
//     }                                                                  
                                                                       
//     public void dfs(char [][]grid, int m, int n, int i, int j) {       
//            grid[i][j] = '0';                                           
//            if (i > 0 && grid[i-1][j] == '1') {                         
//                dfs(grid, m, n, i - 1, j);                              
//            }                                                           
//            if (j > 0 && grid[i][j-1] == '1') {                         
//                dfs(grid, m, n, i, j - 1);                              
//            }                                                           
//            if (i < m - 1 && grid[i+1][j] == '1') {                     
//                dfs(grid, m, n, i + 1, j);                              
//            }                                                           
//            if (j < n - 1 && grid[i][j+1] == '1') {                     
//                dfs(grid, m, n, i, j + 1);                              
//            }                                                           
//     }       
// }



// 广度优先算法，优化后不会超时
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m < 1) {
            return 0;
        }
        int n = grid[0].length;
        if (n < 1) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, m, n, i, j);
                }
            }
        }
        return count;
    }

    public void bfs(char[][] grid, int m, int n, int i, int j) {
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(i * n + j);
        while (!deque.isEmpty()) {
            int v  = deque.removeFirst();
            i = v / n;
            j = v % n;
            grid[i][j] = '0';
            if (i > 0 && grid[i - 1][j] == '1') {
                deque.addLast((i -1) * n + j);
            }
            if (j > 0 && grid[i][j - 1] == '1') {
                deque.addLast(i * n + j - 1);
            }
            if (i < m - 1 && grid[i + 1][j] == '1') {
                deque.addLast((i + 1) * n + j);
            }
            if (j < n - 1 && grid[i][j + 1] == '1') {
                deque.addLast(i * n + j + 1);
            }
        }
    }
}


// 广度优先算法
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m < 1) {
            return 0;
        }
        int n = grid[0].length;
        if (n < 1) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, m, n, i, j);
                }
            }
        }
        return count;
    }

    public void bfs(char[][] grid, int m, int n, int i, int j) {
        Deque<Integer> deque = new LinkedList<>();
        grid[i][j] = '0';
        deque.addLast(i * n + j);
        while (!deque.isEmpty()) {
            int v  = deque.removeFirst();
            i = v / n;
            j = v % n;
            if (i > 0 && grid[i - 1][j] == '1') {
                grid[i - 1][j] = '0';
                deque.addLast((i -1) * n + j);
            }
            if (j > 0 && grid[i][j - 1] == '1') {
                grid[i][j - 1] = '0';
                deque.addLast(i * n + j - 1);
            }
            if (i < m - 1 && grid[i + 1][j] == '1') {
                grid[i + 1][j] = '0';
                deque.addLast((i + 1) * n + j);
            }
            if (j < n - 1 && grid[i][j + 1] == '1') {
                grid[i][j + 1] = '0';
                deque.addLast(i * n + j + 1);
            }
        }
    }
}
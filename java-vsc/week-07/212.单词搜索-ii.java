/*
 * @lc app=leetcode.cn id=212 lang=java
 *
 * [212] 单词搜索 II
 *
 * https://leetcode-cn.com/problems/word-search-ii/description/
 *
 * algorithms
 * Hard (45.26%)
 * Likes:    330
 * Dislikes: 0
 * Total Accepted:    29.8K
 * Total Submissions: 65.8K
 * Testcase Example:  '[["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]\n' +
  '["oath","pea","eat","rain"]'
 *
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
 * 
 * 单词必须按照字母顺序，通过 相邻的单元格
 * 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：board =
 * [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]],
 * words = ["oath","pea","eat","rain"]
 * 输出：["eat","oath"]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：board = [["a","b"],["c","d"]], words = ["abcb"]
 * 输出：[]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * m == board.length
 * n == board[i].length
 * 1 
 * board[i][j] 是一个小写英文字母
 * 1 
 * 1 
 * words[i] 由小写英文字母组成
 * words 中的所有字符串互不相同
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        if (m == 0) {
            return new ArrayList<>();
        }
        int n = board[0].length;
        if (n == 0) {
            return new ArrayList<>();
        }
        if (words.length == 0) {
            return new ArrayList<>();
        }
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                searchWord(board, m, n, trie, i, j, new StringBuffer(), set);
            }
        }
        return new ArrayList<String>(set);
    }

    public void searchWord(char[][] board, int m, int n, Trie trie, int x, int y, StringBuffer output, Set<String> set) {
        if (board[x][y] == '#') {
            return;
        }
        char c = board[x][y];
        output.append(c);
        board[x][y] = '#';
        String outputStr = output.toString();
        Trie node = trie.find(outputStr);
        if (node != null && node.end) {
            set.add(outputStr);
        }
        if (node != null) {
            if (y + 1 < n) {
                searchWord(board, m, n, trie, x, y + 1, output, set);
            }
            if (y - 1 >= 0) {
                searchWord(board, m, n, trie, x, y - 1, output, set);
            }
            if (x - 1 >= 0) {
                searchWord(board, m, n, trie, x - 1, y, output, set);
            }
            if (x + 1 < m) {
                searchWord(board, m, n, trie, x + 1, y, output, set);
            }
        }
        int len = output.length();
        output.delete(len - 1, len);
        board[x][y] = c;
    }
}

class Trie {
    boolean end;
    Trie []tries;

    /** Initialize your data structure here. */
    public Trie() {
        tries = new Trie[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char []sArr = word.toCharArray();
        Trie node = this;
        for (char c : sArr) {
            if (node.tries[c - 'a'] == null) {
                node.tries[c - 'a'] = new Trie();
            }
            node = node.tries[c - 'a'];
        }
        node.end = true;
    }

    public Trie find(String word) {
        char []sArr = word.toCharArray();
        Trie node = this;
        for (char c : sArr) {
            node = node.tries[c - 'a'];
            if (node == null) {
                break;
            }
        }
        return node;
    }
}


// @lc code=end


// 俺的实现，回溯法+前缀树

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        if (m == 0) {
            return new ArrayList<>();
        }
        int n = board[0].length;
        if (n == 0) {
            return new ArrayList<>();
        }
        if (words.length == 0) {
            return new ArrayList<>();
        }
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                searchWord(board, m, n, trie, i, j, new StringBuffer(), set);
            }
        }
        return new ArrayList<String>(set);
    }

    public void searchWord(char[][] board, int m, int n, Trie trie, int x, int y, StringBuffer output, Set<String> set) {
        if (!(x >= 0 && x < m)) {
            return;
        }
        if (!(y >= 0 && y < n)) {
            return;
        }
        if (board[x][y] == '#') {
            return;
        }
        char c = board[x][y];
        output.append(c);
        board[x][y] = '#';
        if (trie.search(output.toString())) {
            set.add(output.toString());
        }
        if (trie.startsWith(output.toString())) {
            searchWord(board, m, n, trie, x, y + 1, output, set);
            searchWord(board, m, n, trie, x, y - 1, output, set);
            searchWord(board, m, n, trie, x - 1, y, output, set);
            searchWord(board, m, n, trie, x + 1, y, output, set);
        }
        int len = output.length();
        output.delete(len - 1, len);
        board[x][y] = c;
    }
}

class Trie {
    boolean end;
    Trie []tries;

    /** Initialize your data structure here. */
    public Trie() {
        tries = new Trie[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word.trim().equals("")) {
            return;
        }
        char []sArr = word.toCharArray();
        Trie node = this;
        for (char c : sArr) {
            if (node.tries[c - 'a'] == null) {
                node.tries[c - 'a'] = new Trie();
            }
            node = node.tries[c - 'a'];
        }
        node.end = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word.trim().equals("")) {
            return false;
        }
        Trie node = find(word);
        return (node != null) && node.end;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix.trim().equals("")) {
            return false;
        }
        Trie node = find(prefix);
        return node != null;
    }

    public Trie find(String word) {
        char []sArr = word.toCharArray();
        Trie node = this;
        for (char c : sArr) {
            node = node.tries[c - 'a'];
            if (node == null) {
                break;
            }
        }
        return node;
    }
}
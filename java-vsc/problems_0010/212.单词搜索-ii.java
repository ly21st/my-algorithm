/*
 * @lc app=leetcode.cn id=212 lang=java
 *
 * [212] 单词搜索 II
 *
 * https://leetcode-cn.com/problems/word-search-ii/description/
 *
 * algorithms
 * Hard (40.80%)
 * Likes:    182
 * Dislikes: 0
 * Total Accepted:    15.7K
 * Total Submissions: 38.4K
 * Testcase Example:  '[["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]\n' +
  '["oath","pea","eat","rain"]'
 *
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * 
 * 
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * 
 * 示例:
 * 
 * 输入: 
 * words = ["oath","pea","eat","rain"] and board =
 * [
 * ⁠ ['o','a','a','n'],
 * ⁠ ['e','t','a','e'],
 * ⁠ ['i','h','k','r'],
 * ⁠ ['i','f','l','v']
 * ]
 * 
 * 输出: ["eat","oath"]
 * 
 * 说明:
 * 你可以假设所有输入都由小写字母 a-z 组成。
 * 
 * 提示:
 * 
 * 
 * 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
 * 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？
 * 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
 * 
 * 
 */

// @lc code=start
class Solution {
    class Trie {
        class TrieNode {
            boolean end;
            TrieNode[]nodes;

            TrieNode() {
                end = false;
                nodes = new TrieNode[26];
            }
        }
        TrieNode root;
        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node = root;
            TrieNode next;
            char []arr = word.toCharArray();
            for (char c : arr) {
                next = node.nodes[c - 'a'];
                if (next == null) {
                    next = new TrieNode();
                    node.nodes[c - 'a'] = next;
                }
                node = next;
            }
            node.end = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = root;
            TrieNode next;
            char []arr = word.toCharArray();
            for (char c : arr) {
                next = node.nodes[c - 'a'];
                if (next == null) {
                    return false;
                }
                node = next;
            }
            return node.end;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            TrieNode next;
            char []arr = prefix.toCharArray();
            for (char c : arr) {
                next = node.nodes[c - 'a'];
                if (next == null) {
                    return false;
                }
                node = next;
            }
            return true;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie tree = new Trie();
        for (String s : words) {
            tree.insert(s);
        }
        Set<String> res = new HashSet<String>();
        int m = board.length;
        if (m < 1) {
            return new ArrayList<String>(res);
        }
        int n = board[0].length;
        if (n < 1) {
            new ArrayList<String>(res);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, m, n, i, j, "", res, tree);
            }
        }
        return new ArrayList<String>(res);
    }

    public void dfs(char[][]board, int m, int n, int i, int j, String word, Set<String>res, Trie tree) {
        if (board[i][j] == '#') {
            return;
        }
        word += board[i][j];
        char tmp = board[i][j];
        board[i][j] = '#';
        if (tree.search(word)) {
            res.add(word);
        }
        if (!tree.startsWith(word)) {
            board[i][j] = tmp;
            return;
        }
        if (i > 0) {
            dfs(board, m, n, i-1, j, word, res, tree);
        }
        if (i < m - 1) {
            dfs(board, m, n, i + 1, j, word, res, tree);
        }
        if (j > 0) {
            dfs(board, m, n, i, j - 1, word, res, tree);
        }
        if (j < n - 1) {
            dfs(board, m, n, i, j + 1, word, res, tree);
        }
        board[i][j] = tmp;
    }
}
// @lc code=end


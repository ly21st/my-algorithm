/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 *
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (69.81%)
 * Likes:    523
 * Dislikes: 0
 * Total Accepted:    73.1K
 * Total Submissions: 104.6K
 * Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n' +
  '[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
 *
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * 
 * 示例:
 * 
 * Trie trie = new Trie();
 * 
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");   
 * trie.search("app");     // 返回 true
 * 
 * 说明:
 * 
 * 
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 * 
 * 
 */

// @lc code=start
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

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end


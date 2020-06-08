package cn.com.leetcode.editor.cn.leetcode.editor.cn;//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
//
// 示例: 
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");   
//trie.search("app");     // 返回 true 
//
// 说明: 
//
// 
// 你可以假设所有的输入都是由小写字母 a-z 构成的。 
// 保证所有输入均为非空字符串。 
// 
// Related Topics 设计 字典树


//leetcode submit region begin(Prohibit modification and deletion)

class TrieNode {
    boolean end;
    final int R = 26;
    TrieNode[] links;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean getEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public TrieNode get(char c) {
        return links[c - 'a'];
    }

    public void set(char c) {
        links[c - 'a'] = new TrieNode();
    }
}


class Trie {
    TrieNode root = new TrieNode();

    /** Initialize your data structure here. */
    public Trie() {
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        insertAux(root, word, 0);
    }

    public void insertAux(TrieNode node, String word, int i) {
        TrieNode next = node.get(word.charAt(i));
        if (next == null) {
            node.set(word.charAt(i));
        }
        next = node.get(word.charAt(i));
        if (i == word.length() - 1) {
            next.setEnd(true);
        } else {
            insertAux(next, word, i + 1);
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return searchAux(root, word, 0);
    }

    public boolean searchAux(TrieNode node, String word, int i) {
        TrieNode next = node.get(word.charAt(i));
        if (next == null) {
            return false;46
        }
        if (i == word.length() - 1) {
            return next.getEnd() == true;
        } else {
            return searchAux(next, word, i + 1);
        }
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return startsWithAux(root, prefix, 0);
    }

    public boolean startsWithAux(TrieNode node, String prefix, int i) {
        TrieNode next = node.get(prefix.charAt(i));
        if (next == null) {
            return false;
        }
        if (i == prefix.length() - 1) {
            return true;
        } else {
            return startsWithAux(next, prefix, i + 1);
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)




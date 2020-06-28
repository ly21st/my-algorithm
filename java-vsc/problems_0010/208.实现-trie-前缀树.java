/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 *
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (67.18%)
 * Likes:    303
 * Dislikes: 0
 * Total Accepted:    38.8K
 * Total Submissions: 57.7K
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

    class TrieNode {
        boolean end;
        TrieNode []nodes;

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

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end



// 前缀树实现，使用额外的数据结构
// class Trie {

//     class TrieNode {
//         boolean end;
//         TrieNode []nodes;

//         TrieNode() {
//             end = false;
//             nodes = new TrieNode[26];
//         }
//     }
//     TrieNode root;
//     /** Initialize your data structure here. */
//     public Trie() {
//         root = new TrieNode();
//     }

//     /** Inserts a word into the trie. */
//     public void insert(String word) {
//         TrieNode node = root;
//         TrieNode next;
//         char []arr = word.toCharArray();
//         for (char c : arr) {
//             next = node.nodes[c - 'a'];
//             if (next == null) {
//                 next = new TrieNode();
//                 node.nodes[c - 'a'] = next;
//             }
//             node = next;
//         }
//         node.end = true;
//     }

//     /** Returns if the word is in the trie. */
//     public boolean search(String word) {
//         TrieNode node = root;
//         TrieNode next;
//         char []arr = word.toCharArray();
//         for (char c : arr) {
//             next = node.nodes[c - 'a'];
//             if (next == null) {
//                 return false;
//             }
//             node = next;
//         }
//         return node.end;
//     }

//     /** Returns if there is any word in the trie that starts with the given prefix. */
//     public boolean startsWith(String prefix) {
//         TrieNode node = root;
//         TrieNode next;
//         char []arr = prefix.toCharArray();
//         for (char c : arr) {
//             next = node.nodes[c - 'a'];
//             if (next == null) {
//                 return false;
//             }
//             node = next;
//         }
//         return true;
//     }
// }
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import javax.swing.event.RowSorterListener;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N叉树的后序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/description/
 *
 * algorithms
 * Easy (74.85%)
 * Likes:    104
 * Dislikes: 0
 * Total Accepted:    37.4K
 * Total Submissions: 50K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 *
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 返回其后序遍历: [5,6,3,2,4,1].
 * 
 * 
 * 
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 */

// @lc code=start

// Definition for a Node.
// class Node {
//     public int val;
//     public List<Node> children;

//     public Node() {}

//     public Node(int _val) {
//         val = _val;
//     }

//     public Node(int _val, List<Node> _children) {
//         val = _val;
//         children = _children;
//     }
// };


// 迭代法
class Solution {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        helper(root, res);
        return res;
    }

    public void helper(Node root, LinkedList<Integer> res) {
        if (root == null) return;
        if (root.children == null) return;
        Deque<Node> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            root = deque.removeLast();
            res.addFirst(root.val);
            for (Node node : root.children) {
                deque.addLast(node);
            }
        }        
    }
}
// @lc code=end


// 递归算法
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(Node root, List<Integer> res) {
        if (root == null) return;
        if (root.children == null) return;
        int n = root.children.size();
        for (int i = 0; i < n; i++) {
            if (root.children.get(i) != null) {
                helper(root.children.get(i), res);
            }
        }
        res.add(root.val);
    }
}


// 迭代法
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(Node root, List<Integer> res) {
        if (root == null) return;
        if (root.children == null) return;
        Deque<Node> deque = new LinkedList<>();
        Node p = root;
        Node pre = null;
        while (p != null || !deque.isEmpty()) {
            while (p != null) {
                deque.addLast(p);
                if (p.children != null && p.children.size() > 0) {
                    p = p.children.get(0);
                } else {
                    p = null;
                }
            }
            p = deque.removeLast();
            if (p.children == null || p.children.size() <= 1 || 
                p.children.get(p.children.size() - 1) == pre) {
                res.add(p.val);
                pre = p;
                p = null;
            } else {
                deque.addLast(p);
                int i = p.children.indexOf(pre);
                p = p.children.get(i + 1);
            }
        }
    }
}
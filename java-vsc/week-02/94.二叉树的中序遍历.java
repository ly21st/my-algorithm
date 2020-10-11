import java.util.Deque;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;


/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (70.96%)
 * Likes:    476
 * Dislikes: 0
 * Total Accepted:    144.5K
 * Total Submissions: 203.2K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的中序 遍历。
 * 
 * 示例:
 * 
 * 输入: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * 输出: [1,3,2]
 * 
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// 莫里斯遍历
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        TreeNode p = root;  
        TreeNode pre;
        while (p != null) {
            if (p.left == null) {
                res.add(p.val);
                p = p.right;
                continue;
            }
            pre = p.left;
            while (pre.right != null && pre.right != p) {
                pre = pre.right;
            }

            if (pre.right == null) {
                pre.right = p;
                p = p.left;
            } else {
                res.add(p.val);
                p = p.right;
                pre.right = null;
            }
        }

    }
}
// @lc code=end



// 递归方法
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        if (root.left != null) {
            helper(root.left, res);
        }
        res.add(root.val);
        if (root.right != null) {
            helper(root.right, res);
        }
    }
}



// 双色标记法
class Solution {
    class MyPair {
        public TreeNode key;
        public Integer val;

        public MyPair(TreeNode key, Integer val) {
            this.key = key;
            this.val = val;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        TreeNode p = root;  
        Deque<MyPair> deque = new LinkedList<>();
        MyPair pair = new MyPair(root, 0);
        deque.addLast(pair);

        while (!deque.isEmpty()) {
            pair = deque.removeLast();
            TreeNode node = pair.key;
            int v = pair.val;
            if ((node.left == null && node.right == null) || v == 1) {
                res.add(node.val);
                continue;
            }
            if (node.right != null) {
                deque.addLast(new MyPair(node.right, 0));
            }
            deque.addLast(new MyPair(node, 1));
            if (node.left != null) {
                deque.addLast(new MyPair(node.left, 0));
            }
        }
    }
}


// 效率高的迭代，但难以实现
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        TreeNode p = root;  
        Deque<TreeNode> deque = new LinkedList<>();
        while (p != null || !deque.isEmpty()) {
            while (p!= null) {
                deque.addLast(p);
                p = p.left;
            }
            p = deque.removeLast();
            res.add(p.val);
            p = p.right;
        }

    }
}
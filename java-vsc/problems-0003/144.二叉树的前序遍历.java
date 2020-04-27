import java.util.Deque;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
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
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        TreeNode cur;
        deque.addFirst(root);
        while (!deque.isEmpty()) {
            cur = deque.removeFirst();
            res.add(cur.val);
            if (cur.right != null) {
                deque.addFirst(cur.right);
            }
            if (cur.left != null) {
                deque.addFirst(cur.left);
            }
        }
    }
}
// @lc code=end


// 递归方法
// class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> res = new ArrayList<Integer>();
//         helper(root, res);
//         return res;
//     }

//     public void helper(TreeNode root, List<Integer> res) {
//         if (root == null) return;
//         res.add(root.val);
//         helper(root.left, res);
//         helper(root.right, res);
//     }
// }
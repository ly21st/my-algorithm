import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !deque.isEmpty()) {
            while (cur != null) {
                deque.add(cur);
                cur = cur.left;
            }
            cur = deque.peekFirst();
            if (cur.right != null) {
                deque.addFirst(cur.right);
               
            } 
            cur = cur.right;
        }
    }
}
// @lc code=end







// 递归方法
// class Solution {
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> res = new ArrayList<Integer>();
//         helper(root, res);
//         return res;
//     }

//     public void helper(TreeNode root, List<Integer> res) {
//         if (root == null) return;
//         if (root.left != null) {
//             helper(root.left, res);
//         }
//         if (root.right != null) {
//             helper(root.right, res);
//         }
//         res.add(root.val);
//     }
// }



// 颜色遍历法
// class Solution {
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> res = new ArrayList<Integer>();
//         helper(root, res);
//         return res;
//     }

//     public void helper(TreeNode root, List<Integer> res) {
//         if (root == null) return;
//         Deque<TreeNode> deque = new LinkedList<TreeNode>();
//         TreeNode cur;
//         deque.addFirst(root);
//         while (!deque.isEmpty()) {
//             cur = deque.removeFirst();
//             if (cur.left == null & cur.right == null) {
//                 res.add(cur.val);
//                 continue;
//             }
//             deque.addFirst(cur);
//             if (cur.right != null) {
//                 deque.addFirst(cur.right);
//                 cur.right = null;
//             } 
//             if (cur.left != null) {
//                 deque.addFirst(cur.left);
//                 cur.left = null;
//             }
//         }
//     }
// }
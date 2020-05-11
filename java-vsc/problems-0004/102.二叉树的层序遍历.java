import java.util.Deque;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (61.45%)
 * Likes:    470
 * Dislikes: 0
 * Total Accepted:    114.6K
 * Total Submissions: 185.4K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * 
 * 
 * 
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回其层次遍历结果：
 * 
 * [
 * ⁠ [3],
 * ⁠ [9,20],
 * ⁠ [15,7]
 * ]
 * 
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
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<List<Integer>> res) {
        if (root == null) return;
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        deque.addLast(root);
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(root.val);
        res.add(list);
        TreeNode node;
        while (!deque.isEmpty()) {
            node = deque.removeFirst();
            if (node.left == null && node.right == null) continue;
            list = new ArrayList<Integer>();
            if (node.left != null) {
                list.add(node.left.val);
                deque.addLast(node.left);
            }
            if (node.right != null) {
                list.add(node.right.val);
                deque.addLast(node.right);
            }
            res.add(list);
        }
    }
}
// @lc code=end


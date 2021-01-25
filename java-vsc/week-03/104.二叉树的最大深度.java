import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
 *
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (75.56%)
 * Likes:    776
 * Dislikes: 0
 * Total Accepted:    336.3K
 * Total Submissions: 444.8K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，找出其最大深度。
 * 
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 返回它的最大深度 3 。
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return helper(root);
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if (size > 0) {
                level ++;
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = q.pollFirst();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }
        return level;
    }
}
// @lc code=end



// 深度优先算法
class Solution {
    public int maxDepth(TreeNode root) {
        return helper(root);
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(helper(root.left), helper(root.right));
    }
}

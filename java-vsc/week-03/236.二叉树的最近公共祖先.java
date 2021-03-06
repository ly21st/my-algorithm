import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 *
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 *
 * algorithms
 * Medium (66.12%)
 * Likes:    913
 * Dislikes: 0
 * Total Accepted:    154.1K
 * Total Submissions: 232.8K
 * Testcase Example:  '[3,5,1,6,2,0,8,null,null,7,4]\n5\n1'
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x
 * 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * 
 * 
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 
 * 
 * 示例 2:
 * 
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * 
 * 
 * 
 * 
 * 说明:
 * 
 * 
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> list = new LinkedList<>();
        TreeNode r = findOneNode(root, p, q, list);
        TreeNode s;
        if (r.val == p.val) {
            s = q;
        } else {
            s = p;
        }
        while (!list.isEmpty()) {
            TreeNode node = list.pollLast();
            if (findNode(node, s)) {
                return node;
            }
        }
        return root;
    
    }

    public TreeNode findOneNode(TreeNode root, TreeNode p, TreeNode q, LinkedList<TreeNode> list) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val) {
            list.add(root);
            return root;
        }
        list.add(root);
        TreeNode node = findOneNode(root.left, p, q, list);
        if (node != null) {
            return node;
        }
        node = findOneNode(root.right, p, q, list);
        if (node != null) {
            return node;
        }
        list.removeLast();
        return null;
    }

    public boolean findNode(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }
        if (root.val == p.val) {
            return true;
        }
        boolean find = findNode(root.left, p);
        if (find) {
            return true;
        }
        find = findNode(root.right, p);
        return find;
    }
}
// @lc code=end


import java.util.Arrays;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (68.82%)
 * Likes:    847
 * Dislikes: 0
 * Total Accepted:    148.1K
 * Total Submissions: 214.9K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 
 * 返回如下的二叉树：
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
    int pre = 0;
    int in = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, (long)Integer.MAX_VALUE + 1);
    }

    public TreeNode helper(int []preorder, int[] inorder, long stop) {
        if (pre == preorder.length) {
            return null;
        }
        int pre = 0; 
        int in = 0;
        TreeNode root = new TreeNode(preorder[pre++]);
        TreeNode node;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.addFirst(root);
        TreeNode curNode = root;
        while (pre < preorder.length) {
            // 
            if (curNode.val == inorder[in]) {
                while (!list.isEmpty() && list.peekFirst().val == inorder[in]) {
                    curNode = list.pollFirst();
                    in++;
                }
                node = new TreeNode(preorder[pre++]);
                curNode.right = node;
                curNode = curNode.right;
                list.addFirst(curNode);
            } else {
                // 作为左子树
                node = new TreeNode(preorder[pre]);
                curNode.left = node;
                curNode = curNode.left;
                list.addFirst(curNode);
                pre++;
            }
        }
        return root;
    }
}
// @lc code=end


class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder);
    }

    public TreeNode helper(int []preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal); 
        int k = 0; 
        for (k = 0; k < inorder.length; k++) {
            if (inorder[k] == rootVal) {
                break;
            }
        }

        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1 + k);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, k);
        root.left = helper(leftPreorder, leftInorder);

        int[] rightPreorder =Arrays.copyOfRange(preorder, 1 + k, preorder.length);
        int[] rightOrder = Arrays.copyOfRange(inorder, k + 1, inorder.length); 
        root.right = helper(rightPreorder, rightOrder);
        return root;

    }
}



// 大神解法
class Solution {
    int pre = 0;
    int in = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, (long)Integer.MAX_VALUE + 1);
    }

    public TreeNode helper(int []preorder, int[] inorder, long stop) {
        if (pre == preorder.length) {
            return null;
        }

        if (inorder[in] == stop) {
            in++;
            return  null;
        }
        int rootVal = preorder[pre++];
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, inorder, rootVal);
        root.right = helper(preorder, inorder, stop);
        return root;
    }
}
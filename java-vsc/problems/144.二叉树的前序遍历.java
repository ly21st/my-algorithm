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

    }

}

// @lc code=end


//  class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//       LinkedList<TreeNode> stack = new LinkedList<>();
//       LinkedList<Integer> output = new LinkedList<>();
//       if (root == null) {
//         return output;
//       }
  
//       stack.add(root);
//       while (!stack.isEmpty()) {
//         TreeNode node = stack.pollLast();
//         output.add(node.val);
//         if (node.right != null) {
//           stack.add(node.right);
//         }
//         if (node.left != null) {
//           stack.add(node.left);
//         }
//       }
//       return output;
//     }
//   }
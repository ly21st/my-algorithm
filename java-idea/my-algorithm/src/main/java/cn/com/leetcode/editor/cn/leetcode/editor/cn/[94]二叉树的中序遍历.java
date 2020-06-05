package cn.com.leetcode.editor.cn.leetcode.editor.cn;//给定一个二叉树，返回它的中序 遍历。
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        TreeNode predecessor;
        while (root != null) {
            if (root.left == null) {
                res.add(root.val);
                root = root.right;
                continue;
            }
            predecessor = root.left;
            while (predecessor.right != null && predecessor.right != root) {
                predecessor = predecessor.right;
            }
            if (predecessor.right == null) {
                predecessor.right = root;
                root = root.left;
            } else {
                predecessor.right = null;
                res.add(root.val);
                root = root.right;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)



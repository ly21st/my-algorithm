/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] 将有序数组转换为二叉搜索树
 *
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/description/
 *
 * algorithms
 * Easy (71.33%)
 * Likes:    497
 * Dislikes: 0
 * Total Accepted:    93.9K
 * Total Submissions: 128.2K
 * Testcase Example:  '[-10,-3,0,5,9]'
 *
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 
 * 示例:
 * 
 * 给定有序数组: [-10,-3,0,5,9],
 * 
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * 
 * ⁠     0
 * ⁠    / \
 * ⁠  -3   9
 * ⁠  /   /
 * ⁠-10  5
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

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// 性能更好，可读性更差
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) return null;
        int n = nums.length;
        if (n < 1) return null;
        return helper(nums, 0, n);
    }

    public TreeNode helper(int[] nums, int first, int end) {
        if (end <= first) return null;
        int mid = first + (end - first) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        if (mid - first == 1) {
            root.left = new TreeNode(nums[first]);
        } else {
            root.left = helper(nums, first, mid);
        }
        if (end - mid - 1 == 1) {
            root.right = new TreeNode(nums[mid+1]);
        } else if (end - mid - 1 > 1) {
            root.right = helper(nums, mid + 1, end);
        }
        return root;
    }
}
// @lc code=end

// 递归方法1
// class Solution {
//     public TreeNode sortedArrayToBST(int[] nums) {
//         if (nums == null) return null;
//         int n = nums.length;
//         if (n < 1) return null;
//         return helper(nums, 0, n);
//     }

//     public TreeNode helper(int[] nums, int first, int end) {
//         if (end <= first) return null;
//         int mid = first + (end - first) / 2;
//         TreeNode root = new TreeNode(nums[mid]);
//         root.left = helper(nums, first, mid);
//         root.right = helper(nums, mid + 1, end);
//         return root;
//     }
// }
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
 *
 * https://leetcode-cn.com/problems/path-sum-iii/description/
 *
 * algorithms
 * Easy (55.07%)
 * Likes:    480
 * Dislikes: 0
 * Total Accepted:    41.3K
 * Total Submissions: 74.5K
 * Testcase Example:  '[10,5,-3,3,2,null,11,3,-2,null,1]\n8'
 *
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 
 * 找出路径和等于给定数值的路径总数。
 * 
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 * 
 * 示例：
 * 
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * 
 * ⁠     10
 * ⁠    /  \
 * ⁠   5   -3
 * ⁠  / \    \
 * ⁠ 3   2   11
 * ⁠/ \   \
 * 3  -2   1
 * 
 * 返回 3。和等于 8 的路径有:
 * 
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
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
    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        Deque<Integer> res = new LinkedList<Integer>();
        helper(root, sum, res);
        return count;
    }

    List<Integer> helper(TreeNode root, int sum, Deque<Integer> res) {
        if (root == null) {
            return null;
        }
        if (root.val == sum) {
            count++;
        }
        int size = res.size();
        res.addLast(root.val);
        for (int i = 0; i < size; i++) {
            res.addLast(root.val + res.);
        }
    }
}
// @lc code=end


// 方法1 自底向上求解
// class Solution {
//     int count = 0;
//     public int pathSum(TreeNode root, int sum) {
//         if (root == null) return 0;
//         helper(root, sum);
//         return count;
//     }

//     List<Integer> helper(TreeNode root, int sum) {
//         if (root == null) {
//             return null;
//         }
//         List<Integer> res = new ArrayList<Integer>();
//         res.add(root.val);
//         List<Integer> leftList = null;
//         List<Integer> rightList = null;
//         if (root.left != null) {
//             leftList = helper(root.left, sum);
//         }
//         if (root.right != null) {
//             rightList = helper(root.right, sum);
//         }
//         if (root.val == sum) {
//             count++;
//         }
//         if (leftList != null) {
//             for (int v : leftList) {
//                 int tmp = root.val + v;
//                 if (tmp == sum) {
//                     count++;
//                 }
//                 res.add(tmp);
//             }
//         }
//         if (rightList != null) {
//             for (int v : rightList) {
//                 int tmp = root.val + v;
//                 if (tmp == sum) {
//                     count++;
//                 }
//                 res.add(tmp);
//             }
//         }
//         return res;
//     }
// }
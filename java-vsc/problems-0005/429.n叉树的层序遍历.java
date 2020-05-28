import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.sun.org.apache.bcel.internal.classfile.Node;

/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N叉树的层序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (65.05%)
 * Likes:    80
 * Dislikes: 0
 * Total Accepted:    18.6K
 * Total Submissions: 28.5K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 *
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 返回其层序遍历:
 * 
 * [
 * ⁠    [1],
 * ⁠    [3,2,4],
 * ⁠    [5,6]
 * ]
 * 
 * 
 * 
 * 
 * 说明:
 * 
 * 
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 * 
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        helper(res, root, 0);
        return res;
    }

    public void helper(List<List<Integer>> res, Node root, int level) {
        if (res.size() == level) {
            List<Integer> list = new ArrayList<Integer>();
            res.add(list);
        }
        res.get(level).add(root.val);
        for (Node child : root.children) {
            if (child != null)
                helper(res, child, level + 1);
        }
    }
}
// @lc code=end


// 广度优先解法
// class Solution {
//     public List<List<Integer>> levelOrder(Node root) {
//         List<List<Integer>> res = new ArrayList<List<Integer>>();
//         helper(res, root);
//         return res;
//     }

//     public void helper(List<List<Integer>> res, Node root) {
//         if (root == null) return;
//         Deque<Node> deque = new LinkedList<Node>();
//         Node cur;
//         deque.addLast(root);
//         while (!deque.isEmpty()) {
//             int size = deque.size();
//             List<Integer> list = new ArrayList<Integer>();
//             for (int i = 0; i < size; i++) {
//                 cur = deque.removeFirst();
//                 list.add(cur.val);
//                 for (Node node : cur.children) {
//                     if (node != null) deque.addLast(node);
//                 }
//             }
//             res.add(list);
//         }
//     }
// }



// 深度优先算法1 
//class Solution {
//     public List<List<Integer>> levelOrder(Node root) {
//         List<List<Integer>> res = new ArrayList<List<Integer>>();
//         if (root == null) return res;
//         helper(res, root, 0);
//         return res;
//     }

//     public void helper(List<List<Integer>> res, Node root, int level) {
//         if (res.size() == level) {
//             List<Integer> list = new ArrayList<Integer>();
//             res.add(list);
//         }
//         if (root == null) return;
//         res.get(level).add(root.val);
//         for (Node child : root.children) {
//             helper(res, child, level + 1);
//         }
//     }
// }
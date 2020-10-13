import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N叉树的层序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (66.78%)
 * Likes:    114
 * Dislikes: 0
 * Total Accepted:    31.2K
 * Total Submissions: 46.7K
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


// 深度优先算法
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, res, 0);
        return res;
    }

    public void helper(Node root, List<List<Integer>> res, int level) {
        if (root == null) return;
        List<Integer> output ;
        if (res.size() <= level) {
            output = new ArrayList<>();
            output.add(root.val);
            res.add(output);
        } else {
            output = res.get(level);
            output.add(root.val);
            res.set(level, output);
        }
        
        for (Node node : root.children) {
            helper(node, res, level + 1);
        }  
    }
}
// @lc code=end


// 使用队列方式，广度优先算法
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(Node root, List<List<Integer>> res) {
        Deque<Node> deque = new LinkedList<>();
        if (root == null) return;
        deque.addLast(root);
        while (!deque.isEmpty()) {
            List<Integer> output = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Node p = deque.removeFirst();
                output.add(p.val);
                for (Node node : p.children) {
                    deque.addLast(node);
                }
            }
            res.add(output);
        }
    }
}
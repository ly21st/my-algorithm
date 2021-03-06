import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
 *
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/description/
 *
 * algorithms
 * Hard (53.29%)
 * Likes:    456
 * Dislikes: 0
 * Total Accepted:    64.2K
 * Total Submissions: 120.2K
 * Testcase Example:  '[1,2,3,null,null,4,5]'
 *
 * 
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 /
 * 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode
 * 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = []
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：root = [1]
 * 输出：[1]
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：root = [1,2]
 * 输出：[1,2]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中结点数在范围 [0, 10^4] 内
 * -1000 
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

 // 深度优先算法
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String s = serializeHelper(root, "");
        // System.out.printf("s:%s", s);
        return s;
    }

    public String serializeHelper(TreeNode root, String str) {
        if (root == null) {
            return str + "null,";
        }
        String s = String.valueOf(root.val) + ",";
        str = str + s;
        str = str + serializeHelper(root.left, "");
        str = str + serializeHelper(root.right, "");
        return str;
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("")) {
            return null;
        }
        String[] strArr = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(strArr));
        return deserializeHelper(list);
    }

    public TreeNode deserializeHelper(List<String> list) {
        if (list.size() == 0) {
            return null;
        }
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = deserializeHelper(list);
        root.right = deserializeHelper(list);
        return root;
    }
}
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end


// 广度优先算法
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<String> strList = new ArrayList<>();
        LinkedList<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);
        while (!nodeList.isEmpty()) {
            TreeNode node = nodeList.poll();
            if (node != null) {
                nodeList.add(node.left);
                nodeList.add(node.right);
                strList.add(new String(String.valueOf(node.val)));
            } else {
                strList.add(null);
            }
        }
        int size = strList.size();
        for (int i = size - 1; i >= 0; i--) {
            if (strList.get(i) == null) {
                strList.remove(i);
            } else {
                break;
            }
        }
        String s = String.join(",", strList);
        // System.out.printf("s:%s", s);
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        int index = data.indexOf(",");
        if (index == -1) {
            return new TreeNode(Integer.valueOf(data));
        }
        LinkedList<TreeNode> nodeList = new LinkedList<>();
        String[] strArr = data.split(",");
        int i = 0;
        TreeNode root = new TreeNode(Integer.valueOf(strArr[i]));
        i++;
        nodeList.add(root);
        while (!nodeList.isEmpty()) {
            TreeNode node = nodeList.poll();
            if (node == null) {
                continue;
            }
            if (i < strArr.length) {
                if (strArr[i].equals("null")) {
                    nodeList.add(null);
                } else {
                    TreeNode left = new TreeNode(Integer.valueOf(strArr[i]));
                    node.left = left;
                    nodeList.add(left);
                }
                i++;
            }
            if (i < strArr.length) {
                if (strArr[i].equals("null")) {
                    nodeList.add(null);
                }
                else {
                    TreeNode right = new TreeNode(Integer.valueOf(strArr[i]));
                    node.right = right;
                    nodeList.add(right);
                }
                i++;
            }
        }
        return root;
    }
}

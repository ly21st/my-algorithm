import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 *
 * https://leetcode-cn.com/problems/linked-list-cycle/description/
 *
 * algorithms
 * Easy (49.35%)
 * Likes:    768
 * Dislikes: 0
 * Total Accepted:    236.7K
 * Total Submissions: 479.6K
 * Testcase Example:  '[3,2,0,-4]\n1'
 *
 * 给定一个链表，判断链表中是否有环。
 * 
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos
 * 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos
 * 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * 
 * 
 * 
 * 进阶：
 * 
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中节点的数目范围是 [0, 10^4]
 * -10^5 <= Node.val <= 10^5
 * pos 为 -1 或者链表中的一个 有效索引 。
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    // class ListNode {
    // int val;
    // ListNode next;

    // ListNode(int x) {
    // val = x;
    // next = null;
    // }
    // }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
// @lc code=end

// 容器标志法
// public class Solution {
// // class ListNode {
// // int val;
// // ListNode next;

// // ListNode(int x) {
// // val = x;
// // next = null;
// // }
// // }

// public boolean hasCycle(ListNode head) {
// Map<ListNode, Boolean> m = new HashMap<>();
// while (head != null) {
// if (m.containsKey(head)) return true;
// m.put(head, true);
// head = head.next;
// }
// return false;
// }
// }

// 繁琐版双指针
// public class Solution {
// // class ListNode {
// // int val;
// // ListNode next;

// // ListNode(int x) {
// // val = x;
// // next = null;
// // }
// // }

// public boolean hasCycle(ListNode head) {
// if (head == null) return false;
// if (head.next == null) return false;
// ListNode slowNode = head.next;
// ListNode fastNode = head.next.next;

// while (slowNode != null && fastNode != null) {
// if (slowNode == fastNode) return true;
// if (slowNode.next == null) return false;
// if (fastNode.next == null || fastNode.next.next == null) return false;
// slowNode = slowNode.next;
// fastNode = fastNode.next.next;
// }
// return false;
// }
// }

// 根据官方代码修改
// public class Solution {
// // class ListNode {
// // int val;
// // ListNode next;

// // ListNode(int x) {
// // val = x;
// // next = null;
// // }
// // }

// public boolean hasCycle(ListNode head) {
// if (head == null) return false;
// if (head.next == null) return false;
// ListNode slowNode = head;
// ListNode fastNode = head.next;

// while (fastNode != null && fastNode.next != null) {
// if (fastNode == null || fastNode.next == null) return false;
// if (slowNode == fastNode) return true;
// if (slowNode.next == null || fastNode.next == null) return false;
// slowNode = slowNode.next;
// fastNode = fastNode.next.next;
// }
// return false;
// }
// }
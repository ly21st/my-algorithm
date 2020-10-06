/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 *
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (66.78%)
 * Likes:    638
 * Dislikes: 0
 * Total Accepted:    154.6K
 * Total Submissions: 231.4K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 
 * 
 * 示例:
 * 
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

// class ListNode {
//     int val;
//     ListNode next;

//     ListNode(int x) {
//         val = x;
//     }
// }


// 迭代法，根据官方方法编写
class Solution {
    public ListNode swapPairs(ListNode head) {
        if ((head == null) || (head.next == null)) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode secondNode;
        ListNode preNode = dummy;
        while (head != null && head.next != null) {
            secondNode = head.next;
            head.next = secondNode.next;

            secondNode.next = head;
            preNode.next = secondNode;

            preNode = head;
            head = head.next;
        }
        return dummy.next;
    }
}
// @lc code=end


// 迭代法

// class Solution {
//     public ListNode swapPairs(ListNode head) {
//         ListNode p1 = head;
//         ListNode p2;
//         ListNode newHead = head;
//         ListNode tmp;
//         ListNode pre = null;
        
//         while (p1 != null && p1.next != null) {
//             tmp = p1.next.next;
//             p2 = p1.next;
//             // 头结点
//             if (p1 == head) {
//                 newHead = p2;
//             } else {
//                 pre.next = p2;
//             }
//             p2.next = p1;
//             p1.next = tmp;
//             pre = p1;
//             p1 = tmp;
//         }
//         return newHead;
//     }
// }



// // 递归方法
// class Solution {
//     ListNode newHead = null;
//     public ListNode swapPairs(ListNode head) {
//         ListNode p1 = head;
//         ListNode p2;

//         if (head == null) return head;
//         if (head.next == null) return head;
//         newHead = head.next;
//         helper(null, head.next.next, head);
//         return newHead;
//     }


//     public void helper(ListNode pre, ListNode next, ListNode node) {
//         ListNode p2 = node.next;
//         p2.next = node;
//         node.next = next;
//         if (pre != null) {
//             pre.next = p2;
//         }
//         if (next != null && next.next != null) {
//             helper(node, next.next.next, next);
//         }
//     }
// }




// // 递归方法,官方方法
// class Solution {
//     public ListNode swapPairs(ListNode head) {
//         if ((head == null) || (head.next == null)) {
//             return head;
//         }
//         ListNode firstNode = head;
//         ListNode secondNode = head.next;

//         firstNode.next = swapPairs(secondNode.next);
//         secondNode.next = firstNode;

//         return secondNode;
//     }
// }
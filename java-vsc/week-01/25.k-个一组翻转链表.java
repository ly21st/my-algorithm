/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 *
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/description/
 *
 * algorithms
 * Hard (63.14%)
 * Likes:    758
 * Dislikes: 0
 * Total Accepted:    105.7K
 * Total Submissions: 167.4K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * 
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 
 * 
 * 
 * 示例：
 * 
 * 给你这个链表：1->2->3->4->5
 * 
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * 
 * 
 * 
 * 说明：
 * 
 * 
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// 优化版本
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        while (head != null) {
            ListNode tail = pre;
            // 查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }

        return hair.next;
    }


    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }
}
// @lc code=end




// class Solution {
//     public ListNode reverseKGroup(ListNode head, int k) {
//         if (head == null) return head;
//         if (head.next == null) return head;
//         if (k < 2) return head;
//         ListNode dummy = new ListNode(-1);
//         int n = 0;
//         ListNode p = head;
//         while (p != null) {
//             n++;
//             p = p.next;
//         }
//         if (n < k) return head;

//         ListNode pre = dummy;
//         p = head;
//         int i = 0;
//         ListNode firstNode = null;
//         while (p != null) {
//             i++;
//             if (i > (int)(n / k) * k) {
//                 pre.next = p;
//                 return dummy.next;
//             }
//             ListNode tmp = p.next;
//             if ((i % k) == 1) {
//                 firstNode = p;
//             }
//             p.next = pre.next;
//             pre.next = p;
//             p = tmp;
//             if ((i % k) == 0) {
//                 pre = firstNode;
//             }
//         }
//         return dummy.next;
//     }
// }




// // 优化版本
// class Solution {
//     public ListNode reverseKGroup(ListNode head, int k) {
//         if (head == null) return head;
//         if (head.next == null) return head;
//         if (k < 2) return head;
//         ListNode dummy = new ListNode(-1);
//         int n = 0;
//         ListNode p = head;
//         while (p != null) {
//             n++;
//             p = p.next;
//         }
//         if (n < k) return head;

//         ListNode pre = dummy;
//         p = head;
//         int i = 0;
//         ListNode nextPre = pre;
//         while (p != null) {
//             i++;
//             if (i > (int)(n / k) * k) {
//                 nextPre.next = p;
//                 return dummy.next;
//             }
//             ListNode tmp = p.next;
//             if ((i % k) == 1) {
//                 pre = nextPre;
//                 nextPre = p;
//             }
//             p.next = pre.next;
//             pre.next = p;
//             p = tmp;
//         }
//         return dummy.next;
//     }
// }


class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        while (head != null) {
            ListNode tail = pre;
            // 查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }

        return hair.next;
    }

    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode pre = tail.next;
        ListNode lastNext = tail.next;
        ListNode p = head;

        while (p != lastNext) {
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return new ListNode[]{tail, head};
    }
}
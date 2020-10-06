/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 *
 * https://leetcode-cn.com/problems/reverse-linked-list/description/
 *
 * algorithms
 * Easy (70.59%)
 * Likes:    1247
 * Dislikes: 0
 * Total Accepted:    341.4K
 * Total Submissions: 483.5K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * 反转一个单链表。
 * 
 * 示例:
 * 
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
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


//  class ListNode {
//       int val;
//       ListNode next;
//       ListNode(int x) { val = x; }
// }


// 递归方法
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        return helper(head, null);
    }

    public ListNode helper(ListNode head, ListNode newHead) {
        ListNode next = head.next;
        head.next = newHead;
        newHead = head;
        if (next != null) {
            return helper(next, newHead);
        } else 
            return newHead;
    }

}
// @lc code=end



//  迭代法
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         ListNode newHeader = null;
//         ListNode next;
//         while (head != null) {
//             next = head.next;
//             head.next = newHeader;
//             newHeader = head;
//             head = next;
//         }
//         return newHeader;
//     }
// }



// 代码收藏
// Java写的一个比较容易理解的递归，思路和第一个解法是一样的；

// class Solution {
//     ListNode pre = null, tmp = null;
//     public ListNode reverseList(ListNode head) {
//         if (head == null)
//             return pre;
//         tmp = head.next;
//         head.next = pre;
//         pre = head;
//         head = tmp;
//         return reverseList(head);
//     }
// }


// 官方递归代码收藏
// public ListNode reverseList(ListNode head) {
//     if (head == null || head.next == null) return head;
//     ListNode p = reverseList(head.next);
//     head.next.next = head;
//     head.next = null;
//     return p;
// }


// 网友精选代码
// class Solution {
// 	public ListNode reverseList(ListNode head) {
// 		//递归终止条件是当前为空，或者下一个节点为空
// 		if(head==null || head.next==null) {
// 			return head;
// 		}
// 		//这里的cur就是最后一个节点
// 		ListNode cur = reverseList(head.next);
// 		//这里请配合动画演示理解
// 		//如果链表是 1->2->3->4->5，那么此时的cur就是5
// 		//而head是4，head的下一个是5，下下一个是空
// 		//所以head.next.next 就是5->4
// 		head.next.next = head;
// 		//防止链表循环，需要将head.next设置为空
// 		head.next = null;
// 		//每层递归函数都返回cur，也就是最后一个节点
// 		return cur;
// 	}
// }


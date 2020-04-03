#! -*- coding:utf-8 -*-

# 编写一个函数，检查输入的链表是否是回文的。
# 示例 1：
#
# 输入： 1->2
# 输出： false
# 示例 2：
#
# 输入： 1->2->2->1
# 输出： true
#  
# 进阶：
# 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if not head or not head.next:
            return True
        slow = head
        fast = head
        new_head = None
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            head.next = new_head
            new_head = head
            head = slow

        if fast:
            slow = slow.next
        head = new_head
        while head:
            if head.val != slow.val:
                return False
            head = head.next
            slow = slow.next
        return True


def print_list(node_list):
    while node_list:
        # print(node_list.val, end=" ")
        print node_list.val,
        node_list = node_list.next
    print("")


if __name__ == '__main__':
    node1 = ListNode(1)
    node2 = ListNode(2)
    node3 = ListNode(2)
    node4 = ListNode(1)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    print_list(node1)

    s = Solution()
    r = s.isPalindrome(node1)
    print(r)

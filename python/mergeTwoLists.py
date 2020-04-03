# -*- coding:utf-8 -*-

#Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

    def add(self, node):
        self.next = node
        node.next = None
        return node

    @staticmethod
    def print(l1):
        while l1 is not None:
            print("{} ".format(l1.val), end=" ")
            l1 = l1.next
        print()


# class Solution(object):
#     def mergeTwoLists(self, l1, l2):
#         """
#         :type l1: ListNode
#         :type l2: ListNode
#         :rtype: ListNode
#         """
#         if l1 is None:
#             return l2
#         if l2 is None:
#             return l1
#         if l2.val < l1.val:
#             new_list = l2
#             l2 = l2.next
#         else:
#             new_list = l1
#             l1 = l1.next
#         cur_node = new_list
#         while l1 is not None and l2 is not None:
#             if l2.val < l1.val:
#                 cur_node.next = l2
#                 l2 = l2.next
#             else:
#                 cur_node.next = l1
#                 l1 = l1.next
#             cur_node = cur_node.next
#         if l1 is not None:
#             cur_node.next = l1
#         else:
#             cur_node.next = l2
#         return new_list




class Solution(object):
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        if not l1: return l2
        if not l2: return l1
        if l2.val < l1.val:
            new_list = l2
            l2 = l2.next
        else:
            new_list = l1
            l1 = l1.next
        cur_node = new_list
        while l1 and l2:
            if l2.val < l1.val:
                cur_node.next = l2
                l2 = l2.next
            else:
                cur_node.next = l1
                l1 = l1.next
            cur_node = cur_node.next
        cur_node.next = l1 or l2
        return new_list



# class Solution(object):
#     def mergeTwoLists(self, l1, l2):
#         """
#         :type l1: ListNode
#         :type l2: ListNode
#         :rtype: ListNode
#         """
#         if not l1: return l2
#         if not l2: return l1
#         if l2.val < l1.val:
#             l2.next = self.mergeTwoLists(l1, l2.next)
#             return l2
#         else:
#             l1.next = self.mergeTwoLists(l1.next, l2)
#             return l1


if __name__ == "__main__":
    s = Solution()
    node1 = ListNode(1)
    node2 = ListNode(2)
    node3 = ListNode(4)
    l1 = node1
    node1.add(node2).add(node3)

    node4 = ListNode(1)
    node5 = ListNode(3)
    node6 = ListNode(4)
    l2 = node4
    node4.add(node5).add(node6)

    ListNode.print(l1)
    ListNode.print(l2)
    new_list = s.mergeTwoLists(l1, l2)
    ListNode.print(new_list)

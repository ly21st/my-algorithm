package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	if l1 == nil {
		return l2
	}
	if l2 == nil {
		return l1
	}
	var newList *ListNode
	if l1.Val <= l2.Val {
		newList = l1
		l1 = l1.Next
	} else {
		newList = l2
		l2 = l2.Next
	}
	curNode := newList
	for l1 != nil && l2 != nil {
		if l1.Val <= l2.Val {
			curNode.Next = l1
			l1 = l1.Next
		} else {
			curNode.Next = l2
			l2 = l2.Next
		}
		curNode = curNode.Next
	}
	if l1 != nil {
		curNode.Next = l1
	} else {
		curNode.Next = l2
	}
	return newList
}

func main() {

}
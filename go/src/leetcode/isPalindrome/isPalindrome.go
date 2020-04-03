package main

import "fmt"

/**
* Definition for singly-linked list.
*/

type ListNode struct {
	Val  int
	Next *ListNode
}

func isPalindrome(head *ListNode) bool {
	var slow= head
	var fast= head
	var nh *ListNode
	if head == nil || head.Next == nil {
		return true
	}
	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
		head.Next = nh
		nh = head
		head = slow
	}
	if fast != nil {
		slow = slow.Next
	}
	head = nh
	for head != nil {
		if head.Val != slow.Val {
			return false
		}
		head = head.Next
		slow = slow.Next
	}
	return true
}

func print(head *ListNode) {
	for head != nil {
		fmt.Printf("%v ", head.Val)
		head = head.Next
	}
	fmt.Println()
}

func main() {
	var node1 = &ListNode{1, nil}
	var node2 = &ListNode{2, nil}
	var node3 = &ListNode{2, nil}
	var node4 = &ListNode{1, nil}
	node1.Next = node2
	node2.Next = node3
	node3.Next = node4
	print(node1)
	r := isPalindrome(node1)
	fmt.Println(r)
}

package g20190343020320

// 21.合并两个有序链表
// https://leetcode-cn.com/problems/merge-two-sorted-lists/
type ListNode struct {
	Val  int
	Next *ListNode
}

func MergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	if l1 == nil {
		return l2
	}
	if l2 == nil {
		return l1
	}

	prev := &ListNode{0, l1}
	head := prev
	for l1 != nil && l2 != nil {
		if l1.Val > l2.Val {
			prev.Next, l2.Next, l2 = l2, l1, l2.Next
		} else {
			l1 = l1.Next
		}
		prev = prev.Next
	}

	if l1 == nil {
		prev.Next = l2
	}

	return head.Next
}

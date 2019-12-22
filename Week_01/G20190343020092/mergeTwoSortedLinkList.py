# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        # 增加一个冗余的节点，方便后续处理
        prehead = ListNode(-1)
        head = prehead
        # 当两个链表都不为空时
        while l1 and l2:
            # 如果l1的val<=l2的val，就将prehead的后继指向l1，此后，l1前进一步
            if l1.val <= l2.val:
                prehead.next, l1 = l1, l1.next
        # 否则，就将prehead的后继指向l2，此后，l2前进一步
            else:
                prehead.next, l2 = l2, l2.next
            prehead = prehead.next
           # 需要考虑l1和l2不等长的情况
           # 如果l1不为空就将p.next指向l2
            # 如果l1为空就指向l2，如果l2也为空那就指向空
            prehead.next = l1 if l1 else l2
        return head.next

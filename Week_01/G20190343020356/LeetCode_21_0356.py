# -*- coding: utf-8 -*-
"""https://leetcode-cn.com/problems/merge-two-sorted-lists"""


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    # 将输入列表转换为链表
    def initList(self, data):
        if len(data) == 0:
            return
        # 头结点
        head = ListNode(data[0])
        # 逐个为 data 内的数据创建结点, 建立链表
        p = head
        for i in data[1:]:
            node = ListNode(i)
            p.next = node
            p = p.next
        return head

    def mergeTwoListsSolutionOne(self, l1: ListNode, l2: ListNode) -> ListNode:
        if l1 and l2:
            # ensure l1 是较小的结点
            if l1.val > l2.val:
                l1, l2 = l2, l1
            l1.next = self.mergeTwoListsSolutionOne(l1.next, l2)
        return l1 or l2

    def mergeTwoListSolutionTwo(self, l1: ListNode, l2: ListNode) -> ListNode:
        # 得到头结点
        """
        cur = ListNode(-1)
        head = cur
        ......
        return head.next
        """
        if l1.val < l2.val:
            cur = l1
            l1 = l1.next
        else:
            cur = l2
            l2 = l2.next
        head = cur
        while l1 and l2:
            if l1.val < l2.val:
                cur.next = l1
                l1 = l1.next
            else:
                cur.next = l2
                l2 = l2.next
            cur = cur.next
        cur.next = l1 if l1 is not None else l2
        return head

    def display_arr(self, node: ListNode) -> []:
        if node is None:
            return []
        res = []
        while node is not None:
            res.append(node.val)
            node = node.next
        return res


if __name__ == "__main__":
    test = Solution()
    data1 = [1, 4, 7, 8]
    data2 = [1, 3, 5]
    l1 = test.initList(data1)
    l2 = test.initList(data2)
    print(test.display_arr(l1))
    print(test.display_arr(l2))
    result = test.mergeTwoListsSolutionOne(l1, l2)
    # result = test.mergeTwoListSolutionTwo(l1, l2)
    print(test.display_arr(result))

package org.azai.train.Week01;

public class Leetcode_21_0132 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
     }

//递归遍历链表  链表节点的下一个节点为本链表的下一个节点或另一个链表的的最小节点
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next,l2);
                return l1;
            }
            l2.next = mergeTwoLists(l2.next,l1);
            return l2;
        }
}

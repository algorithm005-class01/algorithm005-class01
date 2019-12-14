/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //递归, 退出条件为l1或者l2为null
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    // public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
    //     //头指针处理
    //     ListNode senti = new ListNode(-1); //增加一个哨兵节点
    //     ListNode curr = senti;
     
    //     while (l1 != null && l2 != null) {
    //         if (l1.val < l2.val) {
    //             curr.next = l1;
    //             l1 = l1.next;
    //         } else {
    //             curr.next = l2;
    //             l2 = l2.next;
    //         }
    //         curr = curr.next;
    //     }
    //     //尾部处理
    //     if (l1 != null) {
    //         curr.next = l1;
    //     }
    //     if (l2 != null) {
    //         curr.next = l2c;
    //     }

    //     return senti.next;
    // }
}

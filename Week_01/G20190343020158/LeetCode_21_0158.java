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
        /**
         * 思考：非递归的形式，先设置一个虚拟头结点，使用这种方式简化了循环中对链表的访问，返回时也只需要返回该结点的next即可
         * 具体逻辑为判断l1和l2哪个更小，此时头结点指向更小的数据，并且小的链表走向下一个，要返回的链表也走向下一个，重复上述操作，直到l1或l2为空
         * 最后将剩余的链表接到要返回的链表最后
         */
        ListNode pre = new ListNode(-1);
        ListNode temp = pre;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2:l1;
        return pre.next;
    }
}
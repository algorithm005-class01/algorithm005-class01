class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode head = null, mv = null;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        }else {
            head = l2;
            l2 = l2.next;
        }
        mv = head;

        while( l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                mv.next = l1;
                l1 = l1.next;
            }else {
                mv.next = l2;
                l2 = l2.next;
            }
            mv = mv.next;
        }
        mv.next = l1 != null ? l1 : l2;

        return head;
    }
}
public class LeetCode_25_0082 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        while (cur != null) {
            ListNode tmp = cur;
            for (int i = 0; i < k - 1 && cur != null; i++) cur = cur.next;
            if (cur == null) {
                pre.next = tmp;
                break;
            }
            ListNode post = cur.next;
            cur.next = null;
            pre.next = reverse(tmp);
            pre = tmp;
            cur = post;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}

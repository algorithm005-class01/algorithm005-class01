public class LeetCode_24_0082 {

    public ListNode swapPairs(ListNode head) {
        //递归
        //迭代
//        if (head == null || head.next == null) return head;
//        ListNode next = head.next;
//        head.next = swapPairs(next.next);
//        next.next = head;
//        return next;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null && pre.next.next != null) {
            ListNode cur = pre.next;
            ListNode post = cur.next;
            cur.next = post.next;
            post.next = cur;
            pre.next = post;
            pre = cur;
        }
        return dummy.next;
    }


     public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}

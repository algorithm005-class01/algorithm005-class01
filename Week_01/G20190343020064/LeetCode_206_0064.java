package G20190343020064;

/**
 * <p>
 * 反转链表
 * </p>
 *
 * @author mingke.yan@hand-china.com 2020-01-04 4:53 下午
 */
public class LeetCode_206_0064 {

    public ListNode reverseList(ListNode head) {
        ListNode reverse = null;
        ListNode current = head;
        while (current != null) {
            ListNode temp = current.next;
            current.next = reverse;
            reverse = current;
            current = temp;
        }
        return reverse;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

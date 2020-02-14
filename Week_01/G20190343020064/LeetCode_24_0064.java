package G20190343020064;

/**
 * <p>
 * 两两交换链表中的节点
 * </p>
 *
 * @author mingke.yan@hand-china.com 2020-01-22 10:03 上午
 */
public class LeetCode_24_0064 {

    public ListNode swapPairs(ListNode head) {
        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode pre = result;
        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;
            pre.next = second;
            first.next = second.next;
            second.next = first;
            pre = first;
            head = first.next;
        }
        return result.next;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}

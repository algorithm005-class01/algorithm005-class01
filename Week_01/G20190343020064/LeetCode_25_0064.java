package G20190343020064;


/**
 * <p>
 * K 个一组翻转链表
 * </p>
 *
 * @author mingke.yan@hand-china.com 2020-01-23 6:03 下午
 */
public class LeetCode_25_0064 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode start = pre.next;
            // 缓存后续链表
            ListNode next = end.next;
            // 断连
            end.next = null;
            // 翻转 start 到 end 链表
            pre.next = this.reverseGroup(start);
            // 连上后续链表
            start.next = next;
            // 初始化 pre end
            pre = start;
            end = start;
        }

        return dummy.next;
    }

    public ListNode reverseGroup(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        return pre;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}

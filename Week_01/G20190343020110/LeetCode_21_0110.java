import java.util.LinkedList;

/**
 * @Author huangxiong
 * @Date 2019/12/12
 * @Description leectcode题目21 合并两个链表
 **/
public class LeetCode_21_0110 {
    public synchronized ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode result = new ListNode(0);
        ListNode prev = result;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        if (l1 != null) {
            prev.next = l1;
        }
        if (l2 != null) {
            prev.next = l2;
        }
        return result.next;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.remove(1);
        LeetCode_21_0110 code_21 = new LeetCode_21_0110();
        System.out.println(code_21.mergeTwoLists1(null, null));
    }
}

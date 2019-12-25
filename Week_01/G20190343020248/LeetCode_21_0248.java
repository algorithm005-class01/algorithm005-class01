//合并两个有序链表，新链表仍有序

/**
 * 1.递归的使用
 * 2.递归的三个要素
 * 2.1 终止条件：链表.next==null,其中一条链表遍历结束，则比较完成（另一条本身有序，未结束直接往后排不影响顺序）
 * 2.2 返回值：每一层调用都返回排序好的链表头
 * 2.3 递归内容：两个链表l1,l2, 如果l1.val < l2.val,则将l1.next与l2比较，
 * 与剩下的排好序的链表头相比
 */
public class LeetCode_21_0248 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

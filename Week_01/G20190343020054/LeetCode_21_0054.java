public class LeetCode_21_0054 {

    /**
     * 21. 合并两个有序链表
     */

    /**
     *这道题可以使用递归实现，新链表也不需要构造新节点，本题递归三个要素
     *
     * - 终止条件：两条链表分别名为 l1 和 l2，当 l1 为空或 l2 为空时结束
     * - 返回值：每一层调用都返回排序好的链表头
     * - 本级递归内容：如果 l1 的 val 值更小，则将 l1.next 与排序好的链表头相接，l2 同理
     * O(m+n)，m 为 l1的长度，n 为 l2 的长度
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
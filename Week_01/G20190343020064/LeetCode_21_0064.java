package G20190343020064;

/**
 * <p>
 * 合并两个有序链表
 * </p>
 *
 * @author mingke  2019-12-14 4:43 下午
 */
public class LeetCode_21_0064 {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        // 记录头节点，方便返回结果
        ListNode head = listNode;
        //===============================================================================
        //  当 l1 或 l2 比较到队尾时结束循环
        //===============================================================================
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                listNode.next = l1;
                l1 = l1.next;
            } else {
                listNode.next = l2;
                l2 = l2.next;
            }
            listNode = listNode.next;
        }
        //  但是可能 l1 和 l2 还有一个没有对比到最后，所以后面需要将 未对比到最后的链表 接入到结果上
        listNode.next = l1 == null ? l2 : l1;
        return head.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}

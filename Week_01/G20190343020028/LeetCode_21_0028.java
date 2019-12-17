//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表



//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 其中一个链表未空时，另一个链表即结果
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        // 新建头几点
        ListNode head = new ListNode(-1);
        // 移动指针最初指向头结点
        ListNode p = head;

        while (l1 != null && l2 != null) {
            // 将两个原始队列头，较小的那个加入新链表后继节点
            if (l1.val > l2.val) {
                p.next = l2;
                l2 = l2.next;
            } else {
                p.next = l1;
                l1 = l1.next;
            }
            // 节点后移
            p = p.next;
        }

        // 如果其中一个链表没有元素了，将另一个链表接入队尾
        p.next = l1 == null ? l2 : l1;
        // 最终返回的是头节点之后的元素
        return head.next;
    }

    /*public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

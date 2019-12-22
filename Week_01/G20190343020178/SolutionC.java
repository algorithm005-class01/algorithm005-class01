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
class SolutionC {
    public ListNode mergeTwoLists(ListNode aLn, ListNode bLn) {

        if(aLn == null){
            return bLn;
        }
        if(bLn == null){
            return aLn;
        }
        if(aLn.val < bLn.val ){
            aLn.next = mergeTwoLists(aLn.next, bLn);
            return aLn;
        }else{
            bLn.next = mergeTwoLists(aLn,bLn.next);
            return bLn;
        }




    }
}
//leetcode submit region end(Prohibit modification and deletion)

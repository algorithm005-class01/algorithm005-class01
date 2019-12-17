/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
*思路：两个指针，头指针负责标记表头位置，尾指针一路向后增加。最后将未完成的部分之间append到后面。
*/
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);//head负责标记新链表表头位置
        ListNode tail = head;//tail负责标记表尾，插入元素越多，一路往后增加
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next; //尾指针向后移动一位
        }
        if (l1 != null) tail.next = l1;
        if (l2 != null) tail.next = l2;
        
        return head.next;
    }
}


Golang:
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
    
    var head, node * ListNode
    
    if l1 ==nil && l2 == nil {//都为空链表的情况
        return nil
    }
    if l1 == nil {//单个链表为空的情况
        return l2
    }
    if l2 == nil {
        return l1
    }
    if (l1.Val < l2.Val){//设置好head节点的位置，然后用node节点往后扩展链表
        head = l1
        node = l1
        l1 = l1.Next
    } else {
        head = l2
        node = l2
        l2 = l2.Next
    }
    
    for l1 != nil && l2 != nil {
        if l1.Val < l2.Val {
            node.Next = l1
            l1 = l1.Next
        } else {
            node.Next = l2
            l2 = l2.Next
        }
        node = node.Next //node右移一位
    }
    if (l1 != nil){
        node.Next = l1
    }
    if (l2 != nil){
        node.Next = l2
    }
    
    return head    
}

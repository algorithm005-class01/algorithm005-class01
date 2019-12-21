package week01;

/**
 * Description: 合并两个有序链表.
 *
 * @author Wengy
 * @since JDK 1.8
 * @since 1.0.0
 */
public class LeetCode_21_0314 {
  
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    
    ListNode l3 = null;
    ListNode l4 = null;
    if(l1==null) return l2;
    if(l2==null) return l1;
    while(l1!=null || l2!=null) {
      if(l1==null) {
        l3.next=l2;
        break;
      }
      if(l2==null){
        l3.next=l1;
        break;
      }
      int min;
      if(l1.val<=l2.val) {
        min=l1.val;
        l1=l1.next;
      } else {
        min=l2.val;
        l2=l2.next;
      }
      
      ListNode temp = new ListNode(min);
      if(l3==null) {
        
        l3 = new ListNode(min);
        l4=l3;
      } else {
        l3.next=temp;
        l3=l3.next;
      }
    }
    return l4;
  }
  
  class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }
  
}


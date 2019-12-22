/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        /**
         * 思考：快慢指针是一种双指针的方法，快指针每次移动两步，慢指针每次移动一步，
         * 比较的是两个node的引用，引用相同则代表走到同一个位置了
         * 理解思路后，难点为循环条件的判断
         */
        if (head == null) {
         return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != slow) {
         if (fast == null || fast.next == null) {
             return false;
         }
         fast = fast.next.next;
         slow = slow.next;
        }
        return true;

    }
}
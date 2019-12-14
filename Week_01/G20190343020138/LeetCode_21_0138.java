package com.log8.week01;

public class Solution21 {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
        }
    }

    /**
     * 核心：利用 guard
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwolists(ListNode l1,ListNode l2){
        //此处需要特殊注意 不能为空
        ListNode guard = new ListNode(-1);
        ListNode head = guard;
        while(l1 != null && l2 != null){
            if(l1.val<l2.val){
                head.next = l1;
                l1 = l1.next;
            }else{
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        head.next = l2!=null ? l2:l1;
        return guard.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        Solution21 test = new Solution21();

        ListNode  merge = test.mergeTwolists(l1,l2);
        int i = 0;
        while(merge!=null){
            System.out.println(i + "  " + merge.val);
            merge = merge.next;
            i++;
        }
    }
}

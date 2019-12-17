/*
 * @lc app=leetcode.cn id=21 lang=javascript
 *
 * [21] 合并两个有序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function(l1, l2) {
    // console.log(l1)
    let l = new ListNode(), p = l
    while(l1 != null && l2 != null) {
      if(l1.val < l2.val) {
        p.next = l1
        l1 = l1.next
      } else {
        p.next = l2
        l2 = l2.next
      }
      p = p.next 
    } 
    if(l1 != null) {
      p.next = l1
    }
    if(l2 != null) {
      p.next = l2
    }
    
    return l.next
};
// @lc code=end


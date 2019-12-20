/*
 * @lc app=leetcode.cn id=83 lang=javascript
 *
 * [83] 删除排序链表中的重复元素
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
 * @param {ListNode} head
 * @return {ListNode}
 */
var deleteDuplicates = function(head) {
    //1.找终止条件：当head指向链表只剩一个元素的时候，自然是不可能重复的，因此return
    if(head == null || head.next == null) return head;

    //3.每一步要做什么：宏观上考虑，此时head.next已经指向一个去重的链表了，而根据第二步，我应该返回一个去重的链表的头节点。因此这一步应该做的是判断当前的head和head.next是否相等，如果相等则说明重了，返回head.next，否则返回head
    head.next = deleteDuplicates(head.next);

    if(head.val == head.next.val) head = head.next;

    //2.想想应该返回什么值：应该返回的自然是已经去重的链表的头节点
    return head;
};
// @lc code=end


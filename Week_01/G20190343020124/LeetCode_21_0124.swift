/*
 * @lc app=leetcode.cn id=21 lang=swift
 *
 * [21] 合并两个有序链表
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (58.51%)
 * Likes:    750
 * Dislikes: 0
 * Total Accepted:    150.2K
 * Total Submissions: 256.2K
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 
 * 示例：
 * 
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public var val: Int
 *     public var next: ListNode?
 *     public init(_ val: Int) {
 *         self.val = val
 *         self.next = nil
 *     }
 * }
 */
class Solution {
    // 非递归解法

    func mergeTwoLists1(_ l1: ListNode?, _ l2: ListNode?) -> ListNode? {

        if l1 == nil {return l2}
        if l2 == nil {return l1}
        
        var vl1 = l1, vl2 = l2
        let newHead = ListNode.init(0)
        var preHead = newHead
        while (vl1 != nil && vl2 != nil) {
            
            if (vl1!.val < vl2!.val) {
                preHead.next = vl1!
                vl1 = vl1?.next
            } else {
                preHead.next = vl2!
                vl2 = vl2?.next
            }
            preHead = preHead.next!
        }
        preHead.next = vl1 ?? vl2
        return newHead.next
    }
    // 递归解法
    func mergeTwoLists(_ l1: ListNode?, _ l2: ListNode?) -> ListNode? {

        if l1 == nil {return l2}
        if l2 == nil {return l1}
        let p = l1, q = l2
        if (p!.val < q!.val) {
            p!.next = mergeTwoLists(p?.next, q)
            return p
        } else {
            q!.next = mergeTwoLists(q?.next, p)
            return q
        }
    }
}
// @lc code=end


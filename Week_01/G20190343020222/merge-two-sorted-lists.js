/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function(l1, l2) {
    if (!l1) {
        return l2;
    }

    if (!l2) {
        return l1;
    }   

    const dummy = new ListNode(-1);
    let cur = dummy;

    while (l1 && l2) {
        if (l1.val <= l2.val) {
            cur.next = l1;
            cur = l1;
            l1 = l1.next
        } else {
            cur.next = l2;
            cur = l2;
            l2 = l2.next;
        }
    }

    if (l1 || l2) {
        cur.next = l1 ? l1 : l2;
    }

    return dummy.next;
};
// @lc code=end
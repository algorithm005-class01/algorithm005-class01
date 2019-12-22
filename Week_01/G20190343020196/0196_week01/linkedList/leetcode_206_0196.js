/*
 * @lc app=leetcode.cn id=206 lang=javascript
 *
 * [206] 反转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */


// let {LinkedList} = require('./LinkedList');
// let count = 0;

// var reverseList = function(head) {
//     if(head == null || head.next == null) return head;
//     //头变尾， 则头next指向null
//     let prev = null;
//     let cur = head;
//     while(cur){
//         //局部变量先存next
//        let next = cur.next;
//        //将当前的指向反转，指向上一个prev
//        cur.next = prev;
//        //反转完成，挪到下一个
//        prev = cur;
//        cur = next;
//     //    console.log(count++);
//     //    console.log(cur);
//     //    console.log('---------------------------');
//     //    console.log(prev);
//     }
//     return prev;
    
// };




// var reverseList = function(head){
//     return putPreAfterNode(head, null);
// };


// var putPreAfterNode = function(node, pre){
    
//     //base case
//     if(node== null)
//         return pre;
//     //存好next
//     let next = node.next;
//     //反转，指向上一个
//     node.next = pre;
//     console.log(count++);
//     console.log('---------------------');
//     console.log(pre);
//     return putPreAfterNode(next, node);
// }

var reverseList = function(head) {
    //1.终止条件：链表套路
    if ( head == null || head.next == null) return head;

    //根据第二步，返回给上一级的是反转后的链表
    let next = head.next;
    let newHead = reverseList(head.next);
   
    next.next = head;
    head.next = null;
   
    //2.确定返回值，尾指针，即是反转后的头
    return newHead;
};


// @lc code=end

// let testLists = new LinkedList();
// [1,2,3,4,5].forEach((i)=>{ 
//     testLists.append(i)
// });
// console.log(testLists instanceof LinkedList);
// console.log(testLists.toString());
// reverseList(testLists.getHead());
// console.log(testLists instanceof LinkedList);
// console.log(testLists.toString());


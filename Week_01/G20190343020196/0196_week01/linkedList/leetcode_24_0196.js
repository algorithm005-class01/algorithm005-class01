/*
 * @lc app=leetcode.cn id=24 lang=javascript
 *
 * [24] 两两交换链表中的节点
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

// 循环解法不难，花了大量时间锻炼递归思维解法。
// let {LinkedList} = require('./LinkedList');

// let count = 1;

var swapPairs = function(head) {

    //终止条件
    if(head == null || head.next == null){
        return head;
    }

    //递归过程, 找出规律，再写一次拆开函数 验证一下
    
    let next = head.next;

    head.next = swapPairs(next.next);

    // head.next = callback();

    /**拆开代码过程 
     *  callback(){
     *      //head.next.next 即第三个 是否null
     *      //为null， 2—>1->null
     *      //head.next.next.next 第4是否为null
     *      //为null, 2->1->3
     *      //都不为null
     *      //达不到终止条件 继续callback()
     *  }   
     **/
    

    
  
    next.next = head;
  
    // 确定返回值，尾指针，即是反转后的头
    return next;
    
};
// @lc code=end

// let testLists = new LinkedList();
// [1,2,3,4].forEach((i)=>{ 
//     testLists.append(i)
// });
// console.log(testLists instanceof LinkedList);
// console.log(testLists.toString());
// testLists.setHead(swapPairs(testLists.getHead()));
// console.log(testLists.toString());


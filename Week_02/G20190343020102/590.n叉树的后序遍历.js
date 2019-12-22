/*
 * @lc app=leetcode.cn id=590 lang=javascript
 *
 * [590] N叉树的后序遍历
 */

// @lc code=start
/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[]}
 */
var postorder = function (root) {
  // 1.递归  
  // let ans = []
  // func(root,ans)
  // return ans

  // 2.迭代
  let ans = [], stack = [], cur = root
  if(cur != null) {
    stack.push(cur)
  }
  while(stack.length != 0) {
    cur = stack.pop()
    ans.push(cur.val)
    for(let i = 0; i <cur.children.length; i++) {
      if(cur.children[i] != null) {
        stack.push(cur.children[i])
      }
    }
  }
  return ans.reverse()
};
//1。递归
// let func = (node, ans) => {
//   if(node == null) {
//     return
//   }
//   for(let i = 0; i < node.children.length; i++) {
//     func(node.children[i],ans)
//   }
//   ans.push(node.val)
// }
// @lc code=end


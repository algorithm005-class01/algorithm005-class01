/*
 * @lc app=leetcode.cn id=144 lang=javascript
 *
 * [144] 二叉树的前序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var preorderTraversal = function(root) {
    //递归
    // let ans = []
    // func(root,ans)
    // return ans
    
    //迭代
    
    let ans = [], stack = [], cur = root
    if(cur != null) {
      stack.push(cur)
    }
    while(stack.length != 0) {
      cur =  stack.pop()
      ans.push(cur.val)
      if(cur.right != null) {
        stack.push(cur.right)
      }
      if(cur.left != null){
        stack.push(cur.left)
      }
    }    
    return ans
};
// 1.递归
// let func = (node,ans) => {
//   if(node == null) {
//     return
//   }
//   ans.push(node.val)
//   func(node.left,ans)
//   func(node.right,ans)
// }
// @lc code=end


/*
 * @lc app=leetcode.cn id=94 lang=javascript
 *
 * [94] 二叉树的中序遍历
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
var inorderTraversal = function(root) {
  //方案1 递归法 98.83%
  // let number = []
  // func(root,number)
  // return number

  //方案2 迭代  国际站参考 速度很慢 48.21 
  //把所有的左子树压栈，最外面的就是最后一个左节点
  let arr = [], cur = root, stack = []
  while(cur != null || stack.length != 0) {
    while(cur != null) {
      stack.push(cur)
      cur = cur.left
    }
    cur = stack.pop()
    arr.push(cur.val)
    cur = cur.right
  }
  return arr
};
//  方案1，递归法
// let func = (treeNode,number)=> {
//   if(treeNode == null) {
//     return 
//   }
//   func(treeNode.left,number)
//   number.push(treeNode.val)
//   func(treeNode.right,number)
// } 
// @lc code=end


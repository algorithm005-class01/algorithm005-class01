/*
 * @lc app=leetcode.cn id=105 lang=javascript
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
 * @param {number[]} preorder
 * @param {number[]} inorder
 * @return {TreeNode}
 */
var buildTree = function(preorder, inorder) {
  let ans = new TreeNode()
  func(ans,preorder,inorder)  
  // console.log(ans)
  if(ans.val == undefined) {
    return null
  }
  return ans
};
let func = (ans,preorder,inorder) => {
  //console.log(preorder,inorder)
  if(preorder.length == 0) {
    ans.val = inorder[0]
    return 
  } else {
    ans.val = preorder[0]
    let pos = 0 
    for(let i = 0; i < inorder.length; i++) {
      if(inorder[i] == ans.val) {
        pos = i
        break
      }
    }
    let tpre1 = preorder.slice(1,pos), tIno1 =  inorder.slice(0,pos)
    if(tpre1.length != 0 || tIno1.length != 0) {
      ans.left = new TreeNode()
      func(ans.left,tpre1,tIno1)
    }
    let tpre2 = preorder.slice(pos+1,preorder.length),tIno2 = inorder.slice(pos+1,inorder.length)
    if(tpre2.length != 0 || tIno2.length != 0) {
      ans.right = new TreeNode()
      func(ans.right,tpre2,tIno2)
    }
  }
} 
// @lc code=end


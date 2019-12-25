/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
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
  var res = [];

  function loop (node){
    if(!node) return;
    
    res.push(node.val);

    if(node.left){
      loop(node.left);
    }

    if(node.right){
      loop(node.right);
    }
  }

  loop(root);

  return res;
};
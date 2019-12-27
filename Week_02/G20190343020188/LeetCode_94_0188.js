/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * 
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
  var res = [];

  function loop (node){
    if(!node) return [];

    if(node.left){
      loop(node.left);
    }

    res.push(node.val);

    if(node.right){
      loop(node.right);
    }

    return res;
  }

  loop(root);

  return res;
};
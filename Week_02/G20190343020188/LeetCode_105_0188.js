/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 
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
  if (inorder.length === 0) return null;

  return helper(0, 0, inorder.length - 1, preorder, inorder);
};

function helper(preIndex, start, end, preorder, inorder) {
  if (start > end) return null;

  var val = preorder[preIndex];
  var index = inorder.indexOf(val);

  return {
    val,
    left: helper(preIndex + 1, start, index - 1, preorder, inorder),
    right: helper(preIndex + index - start + 1, index + 1, end, preorder, inorder)
  };
}
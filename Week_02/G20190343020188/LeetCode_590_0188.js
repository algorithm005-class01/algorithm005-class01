/**
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 * 
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
var postorder = function(root) {
  var res = [];

  function loop (node){
    if(!node) return;
    
    node.children.forEach(function(c){
      loop(c);
    });

    res.push(node.val);
  }

  loop(root);

  return res;
};
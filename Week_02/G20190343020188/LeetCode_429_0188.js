/**
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 * 
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
  var res = [];

  function loop(node, lv){
    if(!node) return;

    if(res[lv]){
      res[lv].push(node.val);
    }else{
      res[lv] = [node.val];
    }

    node.children.forEach(function(c){
      loop(c, lv + 1);
    });
  }

  loop(root, 0);

  return res;
};
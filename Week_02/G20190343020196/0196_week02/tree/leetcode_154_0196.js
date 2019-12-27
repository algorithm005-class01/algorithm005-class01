/*
 * @lc app=leetcode.cn id=145 lang=javascript
 *
 * [145] 二叉树的后序遍历
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

function TreeNode(val) {
    this.val = val;
    this.left = this.right = null;
}
var postorderTraversal = function (root) {
    let res = [];

    (function pushRoot(root) {
        if (root != null) {
            if (root.left != null) {
                pushRoot(root.left);
            }
            if (root.right != null) {
                pushRoot(root.right);
            }
            res.push(root.val);
        }
    })(root);

    return res;
};

let treeNode = new TreeNode(1);
treeNode.left = new TreeNode(2);
treeNode.right = new TreeNode(3);
treeNode.left.left = new TreeNode(4);
treeNode.left.right = new TreeNode(5);
let arr = postorderTraversal(treeNode);
console.log(arr);
// @lc code=end
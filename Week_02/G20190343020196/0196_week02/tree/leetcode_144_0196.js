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

function TreeNode(val) {
    this.val = val;
    this.left = this.right = null;
}


var preorderTraversal = function (root) {
    let res = [];

    (function pushRoot(root) {
        if (root != null) {
            //根
            res.push(root.val);
            //左
            if (root.left != null) {
                pushRoot(root.left);
            }
            //右
            if (root.right != null) {
                pushRoot(root.right);
            }

        }
    })(root);

    return res;
};

let treeNode = new TreeNode(1);
treeNode.left = new TreeNode(2);
treeNode.right = new TreeNode(3);
treeNode.left.left = new TreeNode(4);
treeNode.left.right = new TreeNode(5);
let arr = preorderTraversal(treeNode);
console.log(arr);
// @lc code=end
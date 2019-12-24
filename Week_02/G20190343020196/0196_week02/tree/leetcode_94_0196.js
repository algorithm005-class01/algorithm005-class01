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
function TreeNode(val) {
    this.val = val;
    this.left = this.right = null;
}

var inorderTraversal = function (root) {

    /*     //解法1
        return root ? [...inorderTraversal(root.left), root.val, ...inorderTraversal(root.right)] : [] */

    //解法2
    let result = [];

    (function pushRoot(root) {
        if (root != null) {
            //左
            if (root.left != null) {
                pushRoot(root.left);
            }
            //中
            result.push(root.val);
            //右
            if (root.right != null) {
                pushRoot(root.right);
            }
        }
    })(root);

    return result;


};

let treeNode = new TreeNode(1);
treeNode.left = new TreeNode(2);
treeNode.right = new TreeNode(3);
treeNode.left.left = new TreeNode(4);
treeNode.left.right = new TreeNode(5);
let arr = inorderTraversal(treeNode);
console.log(arr);
// @lc code=end
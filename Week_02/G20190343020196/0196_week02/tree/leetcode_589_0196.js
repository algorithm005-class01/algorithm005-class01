/*
 * @lc app=leetcode.cn id=589 lang=javascript
 *
 * [589] N叉树的前序遍历
 */

// @lc code=start
/**
 * // Definition for a Node.
 * function Node(val, children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[]}
 */

//递归
var preorder = function (root) {
    let res = [];

    (function pushRoot(root) {
        if (root != null) {
            res.push(root.val);

            for (let i = 0; i < root.children.size(); i++) {
                if (root.children != null) {
                    pushRoot(root.children[i]);
                }
            }
        }
    })(root);

    return res;
};

//栈管理， 先进后出
var preorder2 = function (root) {
    if (!root) return [];

    var res = [],
        arr = [root];
    while (arr.length) {
        var current = arr.pop();
        res.push(current.val);


        for (let i = current.children.length - 1; i >= 0; i--) {
            arr.push(current.children[i]);
        }
    }
    return res;

}
// @lc code=end
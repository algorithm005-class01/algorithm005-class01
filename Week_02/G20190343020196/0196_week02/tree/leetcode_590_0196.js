/*
 * @lc app=leetcode.cn id=590 lang=javascript
 *
 * [590] N叉树的后序遍历
 */

// @lc code=start
/**
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
//递归
var postorder = function (root) {
    let res = [];

    (function pushRoot(root) {
        if (root != null) {


            for (let i = 0; i < root.children.size(); i++) {
                if (root.children != null) {
                    pushRoot(root.children[i]);
                }
            }

            res.push(root.val);
        }
    })(root);

    return res;
};

//栈管理， 先进后出
var postorder2 = function (root) {
    let list = [];
    if (root == null) return list;

    let stack = [root];

    while (stack.length) {
        root = stack.pop();
        list.push(root.val);
        for (const node of root.children) {
            stack.add(node);
        }

    }

    list.reverse();
    return list;

}
// @lc code=end
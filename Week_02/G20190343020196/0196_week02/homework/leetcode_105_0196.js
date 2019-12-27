/*
 * @lc app=leetcode.cn id=105 lang=javascript
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
 * @param {number[]} preorder
 * @param {number[]} inorder
 * @return {TreeNode}
 */
var buildTree = function (preorder, inorder) {
    if (!preorder.length && !inorder.length)
        return null;
    //根据 preorder 找到根节点是 3
    var head = preorder[0];
    //然后根据根节点将 inorder 分成左子树和右子树
    var pos = inorder.indexOf(head);
    var midLeft = inorder.slice(0, pos),
        midRight = inorder.slice(pos + 1);

    //把相应的前序遍历的数组也加进来
    var preLeft = preorder.slice(1, pos + 1),
        preRight = preorder.slice(pos + 1);

    //现在我们只需要构造左子树和右子树即可，成功把大问题化成了小问题
    // 然后重复上边的步骤继续划分，直到 preorder 和 inorder 都为空，返回 null 即可
    var tree = new TreeNode(head);
    tree.left = buildTree(preLeft, midLeft);
    tree.right = buildTree(preRight, midRight);
    return tree;
};
// @lc code=end
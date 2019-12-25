/*
 * @lc app=leetcode.cn id=236 lang=javascript
 *
 * [236] 二叉树的最近公共祖先
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
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */

/* 解法：递归
+ 临界条件：最近公共祖先为根节点
    - 根节点是空节点
    - 根节点是q节点
    - 根节点是p节点
+ 根据临界条件
    - 此题相当于查找以 root 为根节点的树上是否有p节点或者q节点
    - 有，返回p节点或q节点
    - 无，返回null
+ 求解
    - 从左右子树分别进行递归，即查找左右子树上是否有p节点或者q节点
    - 左右子树均无p节点或q节点
    - 左子树找到，右子树没有找到，返回左子树的查找结果
    - 右子树找到，左子树没有找到，返回右子树的查找结果
    - 左、右子树均能找到
    - 说明此时的p节点和q节点在当前root节点两侧，返回root节点 */


var lowestCommonAncestor = function (root, p, q) {
    if (!root || root === p || root === q) return root;
    var resL = lowestCommonAncestor(root.left, p, q);
    var resR = lowestCommonAncestor(root.right, p, q);
    return (resL && resR) ? root : (resL || resR);
};
// @lc code=end
/*
 * @lc app=leetcode.cn id=102 lang=javascript
 *
 * [102] 二叉树的层次遍历
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
 * @return {number[][]}
 */

//DFS
// 每层节点加入数组， 循环后加入结果数组
/* var levelOrder = function (root) {
    let lists = [];
    DFS(root, 0, lists);
    return lists;
};

function DFS(root, level, lists) {
    if (root == null)
        return;

    //当前层数还没元素，先new一个空列表
    if (lists.length <= level) {
        lists.push([]);
    }

    //当值加入
    lists[level].push(root.val);
    DFS(root.left, level + 1, lists);
    DFS(root.right, level + 1, lists);

} */

//bfs
var levelOrder = function (root) {
    if (!root) return [];
    let ret = [],
        queue = [root];

    //外循环负责遍历层级结构
    while (queue.length) {

        let level_size = queue.length;
        let current_level = [];

        // 内循环负责遍历每一层的子节点
        while (level_size--) {
            let node = queue.shift();
            current_level.push(node.val);

            if (node.left) queue.push(node.left);
            if (node.right) queue.push(node.right);

        }
        ret.push(current_level);
    }
    return ret;

}
// @lc code=end
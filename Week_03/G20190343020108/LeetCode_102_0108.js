/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * 解法一：DFS 通过记录访问过的元素及其所在的层
 * @param {TreeNode} root
 * @return {number[][]}
 */
// var levelOrder = function(root) {
//     let res = [];
//     const dfs = (level, node) => {
//         if (!node) return;
//         if (res.length === level) res.push([]);
//         res[level].push(node.val);
//         dfs(level + 1, node.left);
//         dfs(level + 1, node.right);
//     };
//     dfs(0, root);
//     return res;
// };

/**
 * 解法二：BFS
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
    if (!root) return [];
    let res = [],
        queue = [root];
    while (queue.length) {
        let arr = [],
            level = queue.length;
        while (level-- > 0) {
            let node = queue.shift();
            arr.push(node.val);
            if (node.left) queue.push(node.left);
            if (node.right) queue.push(node.right);
        }
        res.push(arr);
    }
    return res;
};
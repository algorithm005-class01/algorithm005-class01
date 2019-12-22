
/**
 * 解法一：递归法
 * @param {Node} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
    if (!root) return [];
    const res = [];
    levelOrderTraversal(root, 0, res);
    return res;
};

/**
 * @param {Node} node
 * @param {number} depth
 * @param {number[][]} res
 * @return {void}
 */
const levelOrderTraversal = (node, depth, res) => {
    if (depth + 1 > res.length) res[depth] = [];
    res[depth].push(node.val);
    if (node.children)
        node.children.forEach(childNode =>
            levelOrderTraversal(childNode, depth + 1, res)
        );
};

/**
 * @param {Node} root
 * @return {number[][]}
 */
var levelOrder2 = function(root) {
    if (!root) return [];
    const res = [];
    const queue = [root];
    let nodeList;
    let current;
    let size;
    while (queue.length) {
        nodeList = [];
        size = queue.length; // 记录每一层
        while (size-- > 0) {
            current = queue.shift(); // 取队列的第一个元素
            nodeList.push(current.val);
            // 将下一层所有的子节点入队
            current.children.forEach(
                childNode => childNode && queue.push(childNode)
            );
        }
        res.push(nodeList); // 添加本层结果到数组中
    }
    return res;
};

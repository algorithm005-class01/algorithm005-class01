/**
 * @param {Node} root
 * @return {number[]}
 */
var preorder = function(root) {
    const res = [];
    preorderTraversal(root, res);
    return res;
};

/**
 * @param {Node} node
 * @param {number[]} res
 * @return {void}
 */
const preorderTraversal = (node, res) => {
    if (!node) return;
    res.push(node.val);
    if (node.children)
        node.children.forEach(childNode => preorderTraversal(childNode, res));
};

/**
 * @param {Node} root
 * @return {number[]}
 */
var preorder2 = function(root) {
    if (!root) return [];
    const res = [];
    const stack = [root];
    let node;
    while (stack.length) {
        node = stack.pop();
        if (node) res.push(node.val);
        if (node && node.children)
            // node.children.forEach(childNode => stack.unshift(childNode));
            node.children.reverse().forEach(childNode => stack.push(childNode));
    }
    return res;
};

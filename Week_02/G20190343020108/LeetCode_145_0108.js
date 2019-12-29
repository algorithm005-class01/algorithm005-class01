/**
 * 解法一：递归法
 * @param {TreeNode} root
 * @return {number[]}
 */
var postorderTraversal = function(root) {
    const res = [];
    traversalPostorder(root, res);
    return res;
};

/**
 * @param {TreeNode} root
 * @param {number[]} res
 */
const traversalPostorder = (root, res) => {
    if (root && root.left) traversalPostorder(root.left, res);
    if (root && root.right) traversalPostorder(root.right, res);
    if (root) res.push(root.val);
};

/**
 * 解法二：使用栈模拟递归（迭代法）
 * @param {TreeNode} root
 * @return {number[]}
 */
var postorderTraversal2 = function(root) {
    if (!root) return [];
    const res = [];
    const stack = [root];
    let current;
    while (stack.length) {
        current = stack.pop();
        if (current) res.unshift(current.val);
        if (current && current.left) stack.push(current.left);
        if (current && current.right) stack.push(current.right);
    }
    return res;
};

/** 另一种写法
 * 解法二：使用栈模拟递归（迭代法）
 * @param {TreeNode} root
 * @return {number[]}
 */
var postorderTraversal3 = function(root) {
    if (!root) return [];
    const res = [];
    const stack = [];
    let current = root;
    while (current || stack.length) {
        while (current) {
            // 当前节点为非空
            res.unshift(current.val); // 将结果添加到队首
            stack.push(current);
            current = current.right; // 进入右子树
        }
        current = stack.pop();
        if (current) current = current.left; // 进入左子树
    }
    return res;
};

/**
 * 解法三：使用颜色标记位来模拟递归（迭代法）
 * @param {TreeNode} root
 * @return {number[]}
 */
var postorderTraversal4 = function(root) {
    if (!root) return [];
    const [WHITE, GRAY] = [0, 1];
    const res = [],
        stack = [[WHITE, root]];
    let color, current;
    while (stack.length) {
        [color, current] = stack.pop();
        if (!current) continue;
        if (color === WHITE) {
            stack.push([GRAY, current]);
            stack.push([WHITE, current.right]);
            stack.push([WHITE, current.left]);
        } else res.push(current.val);
    }
    return res;
};

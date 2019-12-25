
/**
 * 解法一：递归法
 * @param {TreeNode} root
 * @return {number[]}
 */
var preorderTraversal = function(root) {
    const res = [];
    traversalPreorder(root, res);
    return res;
};

/**
 * @param {TreeNode} root
 * @param {number[]} res
 */
const traversalPreorder = (root, res) => {
    if (root) res.push(root.val);
    if (root && root.left) traversalPreorder(root.left, res);
    if (root && root.right) traversalPreorder(root.right, res);
};

/**
 * 解法二：使用栈来模拟递归（迭代法）
 * @param {TreeNode} root
 * @return {number[]}
 */
var preorderTraversal2 = function(root) {
    if (!root) return [];
    const res = [];
    const stack = [root];
    let current;
    while (stack.length) {
        current = stack.pop();
        if (current) res.push(current.val);
        if (current && current.right) stack.push(current.right);
        if (current && current.left) stack.push(current.left);
    }
    return res;
};

/**
 * 另一种写法
 * 解法二：使用栈来模拟递归（迭代法）
 * @param {TreeNode} root
 * @return {number[]}
 */
var preorderTraversal3 = function(root) {
    if (!root) return [];
    const res = [];
    const stack = [];
    let current = root;
    while (current || stack.length) {
        while (current) {
            // 若当前节点非空
            res.push(current.val);
            stack.push(current);
            current = current.left; // 进入左子树
        }
        current = stack.pop();
        if (current) current = current.right; // 进入右子树
    }
    return res;
};

/**
 * 解法三：使用颜色标记位来模拟递归 （迭代法）
 * @param {TreeNode} root
 * @return {number[]}
 */
var preorderTraversal4 = function(root) {
    if (!root) return [];
    const [WHITE, GRAY] = [0, 1]; // WHITE - 未处理， GRAY - 已处理
    const stack = [[WHITE, root]]; // 初始状态： 根节点 未访问
    const res = [];
    let color, current;
    while (stack.length) {
        [color, current] = stack.pop();
        if (!current) continue;
        if (color === WHITE) {
            stack.push([WHITE, current.right]);
            stack.push([WHITE, current.left]);
            stack.push([GRAY, current]);
        } else res.push(current.val);
    }
    return res;
};

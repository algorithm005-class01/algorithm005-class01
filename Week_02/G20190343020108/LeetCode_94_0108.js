
/**
 * 方法一：使用递归
 * @param {TreeNode} root
 * @return {number[]}
 */
var inorderTraversal = function(root) {
    const res = [];
    traversal(root, res);
    return res;
};

/**
 * @param {TreeNode} root
 * @param {number[]} res
 * @return {void}
 */
const traversal = (root, res) => {
    if (root && root.left) traversal(root.left, res);
    if (root) res.push(root.val);
    if (root && root.right) traversal(root.right, res);
};

/**
 * 方法二：使用栈来模拟递归
 * @param {TreeNode} root
 * @return {number[]}
 */
var inorderTraversal2 = function(root) {
    const res = [];
    const stack = [];
    let cur = root;
    while (cur !== null || stack.length) {
        while (cur !== null) {
            stack.push(cur); // 依次遍历左子树上的结点及子树根节点 并入栈
            cur = cur.left;
        }
        // cur 遍历指针为 null，说明已经遍历到左子树最左结点，从栈中弹出栈顶结点
        cur = stack.pop();
        res.push(cur.val); // 将当前结点的值添加到结果中
        cur = cur.right; // 访问右子树
    }

    return res;
};

/**
 * 方法三：使用带有访问标志的栈来模拟递归
 * @param {TreeNode} root
 * @return {number[]}
 */
var inorderTraversal3 = function(root) {
    const [WHITE, GRAY] = [0, 1]; // WHITE - 未访问的新结点； GRAY - 已访问的结点
    const res = [];
    const stack = [[WHITE, root]];
    let color, node;
    while (stack.length) {
        [color, node] = stack.pop(); // 若栈中有元素，则按照左节点、根节点、右节点的顺序依次弹出元素
        if (!node) continue;
        if (color === WHITE) {
            // 当前指向的结点是未访问过的结点，将其右节点，根节点，左节点依次入栈
            stack.push([WHITE, node.right]);
            stack.push([GRAY, node]);
            stack.push([WHITE, node.left]);
        } else res.push(node.val);
    }
    return res;
};

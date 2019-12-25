// 1. Recursive solution:
// var inorderTraversal = function(root) {
//     const result = [];
    
//     return helper(root, result);
// };

// var helper = function(node, list) {
//     if (node) {
//         helper(node.left, list);
//         list.push(node.val);
//         helper(node.right, list);
//     }
//     return list;
// }

// 2. Iterative solution
var inorderTraversal = function(root) {
    const result = [];
    const stack = [];
    let current = root;
    
    while (current || stack.length > 0) {
        while (current) {
            stack.push(current);
            current = current.left;
        }
        current = stack.pop();
        result.push(current.val);
        current = current.right;        
    }
    
    return result;
}
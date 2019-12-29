// 1. Recursive solution
// var preorderTraversal = function(root) {
//     const result = [];
//     return helper(root, result);
// };

// var helper = function(node, list) {
//     if (node) {
//         list.push(node.val);
//         helper(node.left, list);
//         helper(node.right, list);
//     }
    
//     return list;
// }

// 2. Iterative solution(1) using stack
// var preorderTraversal = function(root) {
//     const result = [];
//     const stack = [root];
    
//     while (stack.length > 0) {
//         const current = stack.pop();
        
//         if (current) {
//             result.push(current.val);
//             stack.push(current.right);
//             stack.push(current.left);
//         }
//     }
    
//     return result;
// };

// 3. Iterative solution(2) using stack.
// Only push right nodes into the stack.
var preorderTraversal = function(root) {
    const result = [];
    const stack = [];
    let current = root;
    
    while (current || stack.length > 0) {
        if (current) {
            result.push(current.val);
            stack.push(current.right);
            current = current.left;
        } else {
            current = stack.pop();
        }
    }
    
    return result;
};
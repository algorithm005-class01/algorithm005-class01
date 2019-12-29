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
// BFS
// var levelOrder = function(root) {
//     if (!root) {
//         return [];
//     }
    
//     let q = [root];
//     const result = [];
    
//     while (q.length > 0) {
//         const nextLevel = [];
//         const curResult = [];
//         for (const node of q) {
//             if (node) {
//                 curResult.push(node.val);
//                 if (node.left) {
//                     nextLevel.push(node.left);
//                 }
                
//                 if (node.right) {
//                     nextLevel.push(node.right);
//                 }
//             }
//         }
//         result.push(curResult);
//         q = nextLevel;
//     }
    
//     return result;
// };
var levelOrder = function(root) {
    const result = [];
    
    return dfsHelper(root, result, 0);
}

var dfsHelper = function(curNode, result, height) {
    if (!curNode) {
        return result;
    }
    
    if (result[height]) {
        result[height].push(curNode.val);
    } else {
        result[height] = [curNode.val];
    }
    
    if (curNode.left) {
        dfsHelper(curNode.left, result, height + 1);
    }
    
    if (curNode.right) {
        dfsHelper(curNode.right, result, height + 1);
    }
    
    return result;
}

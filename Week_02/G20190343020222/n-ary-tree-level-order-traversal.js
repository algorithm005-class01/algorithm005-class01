/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
    if (!root) {
        return [];
    }
    let curLevel = [root];
    const result = [];
    
    while (curLevel.length > 0) {
        let nextLevel = [];
        result.push(curLevel.map(item => item.val));
        for (let node of curLevel) {
            if (node.children.length > 0) {
                nextLevel = nextLevel.concat(node.children);
            }
        }
        curLevel = nextLevel;
    }
    
    return result;
};
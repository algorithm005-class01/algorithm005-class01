var preorder = function(root) {
    let stack = [root];
    const result = [];
    let current;
    while (stack.length > 0) {
        current = stack.shift();
        
        if (current) {
            result.push(current.val);
            stack = current.children.concat(stack);
        }
    }
    return result;
};
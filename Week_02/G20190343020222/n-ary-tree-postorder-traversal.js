var postorder = function(root) {
    const result = [];
    let stack = [root];
    
    while (stack.length > 0) {
        // pop not shift
        let current = stack.pop();
        
        if (current) {
            result.unshift(current.val);
            stack = stack.concat(current.children);
        }
    }
    
    return result;
};
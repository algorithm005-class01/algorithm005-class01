var inorderTraversal = function(root) {
    var result = [];
    function pushRoot(root){
        if(root != null){
            if(root.left != null){
                pushRoot(root.left);
            }
            result.push(root.val);
            if(root.right !=null){
                pushRoot(root.right);
            }
        }
    }
    pushRoot(root);
    return result;
};
class Solution {
    
    List<Integer> list = new ArrayList<>();

    /**
     * 递归
     **/
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }

    /**
     * 迭代
     **/
    public List <Integer> inorderTraversal(TreeNode root) {
        List <Integer > res = new ArrayList <> ();
        Stack <TreeNode> stack = new Stack <> ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}
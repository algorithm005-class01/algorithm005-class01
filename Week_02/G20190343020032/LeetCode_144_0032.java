class Solution {
    List<Integer> list = new ArrayList<>();

    /** 
     * 迭代
     **/
    public List<Integer> preorderTraversal1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);
        List<Integer> list = new ArrayList<>();

        while (nodeStack.size() != 0) {
            TreeNode node = nodeStack.pop();
            list.add(node.val);
            if (node.right != null) {
                nodeStack.push(node.right);
            }
            if (node.left != null) {
                nodeStack.push(node.left);
            }
        }

        return list;
    }

    /** 
     * 递归
     **/
    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }
}
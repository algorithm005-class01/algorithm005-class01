//1.递归
class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    public void helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        helper(root.left, result);
        result.add(root.val);
        helper(root.right, result);
    }

}
//2.遍历
class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                cur = node.right;
            }
        }

        return result;
    }

}
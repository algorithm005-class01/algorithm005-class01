//老规矩，先递归解决
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    public void helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        helper(root.left, result);
        helper(root.right, result);
    }
}

//接下来，循环遍历解决, 其实模版都是一样无非是这句result.add(cur.val);放在什么位置
class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while(cur != null) {
                result.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            if (node.right != null) {
                cur = node.right;
            }
        }
        return result;
    }

}
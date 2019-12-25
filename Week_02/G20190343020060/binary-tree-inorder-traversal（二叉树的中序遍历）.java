binary-tree-inorder-traversal（二叉树的中序遍历）
//递归
//基于栈遍历
class Solution {
    public List < Integer > inorderTraversal(TreeNode root) {
        // List < Integer > res = new ArrayList < > ();
        // helper(root, res);
        // return res;
        List<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        TreeNode cur = root;
        while (cur!=null || !satck.isEmpty ) {
        	while (cur!=null) {
        		stack.push(cur);
        		cur = cur.left;
        	}
        	cur = stack.pop();
        	res.add(cur);
        	cur = cur.right; 

        }
        return res;
    }

    // public void helper(TreeNode root, List < Integer > res) {
    //     if (root != null) {
    //         if (root.left != null) {
    //             helper(root.left, res);
    //         }
    //         res.add(root.val);
    //         if (root.right != null) {
    //             helper(root.right, res);
    //         }
    //     }
    // }
}


package Week02_0106;

import java.util.*;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> v = new ArrayList<>();

        while(!stack.isEmpty() || root != null){
            if (root != null){
                stack.add(root);
                root = root.left;
            } else {
                if (stack.size() > 0) {
                    root = stack.peek();
                    stack.pop();
                    v.add(root.val);
                    root = root.right;
                }
            }
        }
        return v;
    }
}

/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

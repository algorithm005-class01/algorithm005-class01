package week_02.commit;

import java.util.*;

// 589. N叉树的前序遍历
// https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
public class Solution_589 {

    // 递归求解
    public static List<Integer> preorder(Node root) {

        List<Integer> result = new ArrayList<>();
        recursion(root, result);
        return result;

    }

    private static void recursion(Node root, List<Integer> result) {
        if (null == root) {
            return;
        }
        result.add(root.val);
        if (root.children != null) {
            for (Node node : root.children) {
                recursion(node, result);
            }
        }
    }

    public static List<Integer> preorder2(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        if(null == root){
            return result;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            result.addLast(cur.val);
            if(cur.children != null){
                Collections.reverse(cur.children);
                for (Node node : cur.children) {
                    stack.push(node);
                }
            }
        }
        return result;

    }
}

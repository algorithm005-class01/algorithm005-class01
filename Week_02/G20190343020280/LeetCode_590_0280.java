//给定一个 N 叉树，返回其节点值的后序遍历。
//
// 例如，给定一个 3叉树 :
//
//
//
//
//
//
//
// 返回其后序遍历: [5,6,3,2,4,1].
//
//
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> postorder(Node root) {
        /*List<Integer> list = new ArrayList<Integer>();
        postorder(root, list);
        return list;*/
        return postorderByLoop(root);
    }

    private void postorder (Node node, List<Integer> list) {
        if (node!=null && node.children!=null) {
            for (Node child : node.children) {
                postorder(child, list);
            }
        }
        if (node!=null) {
            list.add(node.val);
        }
    }

    private List<Integer> postorderByLoop (Node node) {
        List<Integer> list = new LinkedList<Integer>();
        Stack<Node> stack = new Stack<Node>();
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            if (node!=null) {
                list.add(0, node.val); //和二叉树遍历一样，其实这是逆序写法
                if (node.children!=null) {
                    for (Node child : node.children) {
                        stack.push(child);
                    }
                }
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

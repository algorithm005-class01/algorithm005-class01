//给定一个 N 叉树，返回其节点值的前序遍历。
//
// 例如，给定一个 3叉树 :
//
//
//
//
//
//
//
// 返回其前序遍历: [1,3,5,6,2,4]。
//
//
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树


import java.util.ArrayList;
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
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        preorder(root, list);
        return list;
    }

    private void preorder (Node node, List<Integer> list) {
        if (node!=null) {
            list.add(node.val);
            if (node.children!=null) {
                for (int i = 0; i < node.children.size(); i++) {
                    Node child = node.children.get(i);
                    preorder(child, list);
                }
            }
        }
    }

    private List<Integer> preorderByLoop (Node node) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<Node> stack = new Stack<Node>();
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            list.add(node.val);
            if (node.children!=null) {
                for (int i = node.children.size()-1; i>=0;  i--) { //从孩子右到左压入栈，从左到右出栈
                    stack.push(node.children.get(i));
                }
            }
        }
        return list;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

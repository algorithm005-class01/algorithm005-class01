import java.util.ArrayList;
import java.util.List;

public class LeetCode_589_0192 {

    // 589. N叉树的前序遍历 https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/

    List<Integer> list = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return list;
        }

        list.add(root.val);
        for (Node node : root.children) {
            preorder(node);
        }

        return list;
    }

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
    }
}

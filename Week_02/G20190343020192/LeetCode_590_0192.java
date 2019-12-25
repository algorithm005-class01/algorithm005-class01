import java.util.ArrayList;
import java.util.List;

public class LeetCode_590_0192 {

    // 590. N叉树的后序遍历 https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list;
    }

    public void traversal(Node root, List<Integer> list){
        if (root == null) {
            return;
        }
        for (Node node : root.children) {
            traversal(node, list);
        }
        list.add(root.val);
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

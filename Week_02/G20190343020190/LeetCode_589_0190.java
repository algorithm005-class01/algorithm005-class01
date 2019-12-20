import java.util.LinkedList;
import java.util.List;

public class LeetCode_589_0190 {
    private List<Integer> list = new LinkedList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) return list;
        list.add(root.val);
        for (Node child : root.children) {
            preorder(child);
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

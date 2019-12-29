import java.util.LinkedList;
import java.util.List;

public class LeetCode_590_0190 {
    private List<Integer> list = new LinkedList<>();

    public List<Integer> postorder(Node root) {
        if (root == null) return list;
        for (Node child : root.children) {
            postorder(child);
        }
        list.add(root.val);
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

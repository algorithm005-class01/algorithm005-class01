import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_429_0190 {
    private List<List<Integer>> listList = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        this.help(root, 0);
        return listList;
    }

    private void help(Node node, int depth) {
        if (node == null) return;
        if (listList.size() <= depth) {
            listList.add(new LinkedList<>());
        }
        listList.get(depth).add(node.val);
        for (Node child : node.children) {
            help(child, depth + 1);
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}

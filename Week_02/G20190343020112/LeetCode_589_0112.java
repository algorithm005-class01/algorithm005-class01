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
        return preorder(root, new ArrayList<Integer>());
    }

    private List<Integer> preorder(Node root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            if (root.children != null && !root.children.isEmpty()) {
                for (Node node : root.children) {
                    preorder(node, res);
                }
            }
        }
        return res;
    }
}
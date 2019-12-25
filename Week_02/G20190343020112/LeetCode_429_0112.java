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
    public List<List<Integer>> levelOrder(Node root) {
        return root == null ? Collections.EMPTY_LIST : levelOrder(Arrays.asList(root), new ArrayList<List<Integer>>(5000));
    }

    private List<List<Integer>> levelOrder(List<Node> nodes, List<List<Integer>> res) {
        if (nodes != null && !nodes.isEmpty()) {
            List<Node> nextLevel = new ArrayList<>();
            List<Integer> intList = new ArrayList<>();
            for (Node node : nodes) {
                if (node.children != null && !node.children.isEmpty()) {
                    nextLevel.addAll(node.children);
                }
                intList.add(node.val);
            }
            res.add(intList);
            levelOrder(nextLevel, res);
        }
        return res;
    }
}
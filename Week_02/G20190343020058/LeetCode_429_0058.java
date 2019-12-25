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
        List<List<Integer>> res = new LinkedList<>();
        helper(root, res, 0);
        return res; 
    }
    
    public void helper(Node root, List<List<Integer>> res, int level) {
        if (root != null) {
            if(res.size() <= level)
                res.add(new ArrayList<Integer>());
            res.get(level).add(root.val);
            for (Node node : root.children) {
                helper (node, res, level + 1);
            }
            
        }
    }
}
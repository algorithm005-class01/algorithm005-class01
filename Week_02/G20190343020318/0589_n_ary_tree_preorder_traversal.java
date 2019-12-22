class Solution {
    public void preorder(Node root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        for (Node i : root.children)
            preorder(i, res);
    }
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }
}
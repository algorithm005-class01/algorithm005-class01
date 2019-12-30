class Solution {
    public void postorder(Node root, List<Integer> res) {
        if (root == null) return;
        for (Node i : root.children)
            postorder(i, res);
        res.add(root.val);
    }
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }
}
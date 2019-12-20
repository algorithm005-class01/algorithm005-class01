public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;
    helper(root, 0, res);
    return res;
}

private void helper(Node root, int depth, List<List<Integer>> res) {
    if (root == null) return;
    //判断是否是新的一层
    if (depth + 1 > res.size()) {
        res.add(new ArrayList<>());
    }
    res.get(depth).add(root.val);

    //处理子节点
    for (Node node : root.children) {
        if (node != null) {
            helper(node, depth + 1, res);
        }
    }
}
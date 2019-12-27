//1.递归
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        helper(Arrays.asList(root), result);
        return result;
    }

    public void helper(List<Node> roots, List<List<Integer>> result) {
        if (roots == null || roots.isEmpty()) {
            return;
        }
        List<Integer> res = new ArrayList<>();
        List<Node> childrens = new ArrayList<>();
        for (Node node : roots) {
            res.add(node.val);
            if (node.children != null && !node.children.isEmpty()) {
                childrens.addAll(node.children);
            }
        }
        result.add(res);
        helper(childrens, result);
    }
}
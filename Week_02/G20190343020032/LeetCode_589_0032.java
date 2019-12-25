class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        helper(root);
        return list;
    }

    private void helper(Node root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        int size = root.children.size();
        for (int i = 0; i < size; i++) {
            helper(root.children.get(i));
        }
    }


    public List<Integer> preorder2(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node removedNode = stack.pop();
            list.add(removedNode.val);
            if (removedNode.children != null && removedNode.children.size() > 0) {
                for (int i = removedNode.children.size() - 1; i >= 0; i--) {
                    stack.push(removedNode.children.get(i));
                }
            }
        }
        return list;
    }
}
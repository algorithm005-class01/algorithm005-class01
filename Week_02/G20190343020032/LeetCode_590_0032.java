class Solution {
    List<Integer> list = new ArrayList<>();
    /**
     * 递归
     **/
    public List<Integer> postorder(Node root) {
        helper(root);
        return list;
    }

    private void helper(Node root) {
        if (root == null) {
            return;
        }
        int size = root.children.size();
        for (int i = 0; i < size; i++) {
            helper(root.children.get(i));
        }
        list.add(root.val);
    }

    /**
     * 双倒序解决后序遍历
     **/
    public List<Integer> postorder2(Node root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            // 头插法倒序
            list.addFirst(node.val);
            // 栈的先入后出特性再次倒序
            stack.addAll(node.children);
        }
        return list;
    }
}
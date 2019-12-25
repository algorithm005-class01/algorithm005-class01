//1.递归
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    public void helper(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        if (root.children != null && !root.children.isEmpty()) {
            for (Node child : root.children) {
                helper(child, result);
            }
        }

    }
}

//2.循环遍历
class Solution {

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                result.add(cur.val);
                if (cur.children != null && !cur.children.isEmpty()) {
                    cur = cur.children.get(0);
                } else {
                    cur = null;
                }
            }
            Node node = stack.pop();
            if (!stack.isEmpty()) {
                Node parent = stack.peek();
                Boolean flag = false;
                for (Node child : parent.children) {
                    if (flag) {
                        cur = child;
                        break;
                    }
                    if (child == node) {
                        flag = true;
                    }
                }
            }
        }
        return result;
    }

}
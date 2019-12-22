// ====递归====
// 思路：
// 1. 当前node不为空的时候先添加到结果集中
// 2. 再判断当前node的子节点，依次执行相同的操作

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(Node root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            List<Node> childrens = root.children;
            if (childrens != null) {
                for (int i = 0; i < childrens.size(); i++) {
                    helper(childrens.get(i), res);
                }
            }
        }
    }
}

// ====迭代====
// 1.弹出最后入栈的node
// 2.如果当前node有子节点，则将其子节点反转后入栈，保证每次弹出的顺序是各层从左到右的顺序
class Solution {
    public List<Integer> preorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.add(node.val);
            if (node.children != null) {
                Collections.reverse(node.children);
                for (Node item : node.children) {
                    stack.add(item);
                }
            }
        }
        return output;
    }
}
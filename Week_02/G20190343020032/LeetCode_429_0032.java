public class Solution {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    List<List<Integer>> result = new ArrayList<>();

    /**
     * 递归解法
     **/
    public List<List<Integer>> levelOrder1(Node root) {
        levelOrderSearch(root, 0);
        return result;
    }

    void levelOrderSearch(Node root, int level) {
        if (root != null) {
            List<Integer> list;
            if (result.size() == level) {
                list = new ArrayList<>();
                result.add(list);
            } else {
                list = result.get(level);
            }
            list.add(root.val);
            List<Node> arr = root.children;
            for (Node node : arr) {
                levelOrderSearch(node, level + 1);
            }
        }
    }

    /**
     * 非递归解法
     **/
    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> levelNode = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node removedNode = queue.poll();
                levelNode.add(removedNode.val);
                if (removedNode.children != null && removedNode.children.size() > 0) {
                    for (Node child : removedNode.children) {
                        queue.add(child);
                    }
                }
            }

            list.add(levelNode);
        }
        return list;
    }
}

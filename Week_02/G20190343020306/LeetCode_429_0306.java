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
/*
思路: 引入一个队列记录本层次所有的节点
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> totalList = new ArrayList<>();
        if (root != null) {
            totalList.add(new ArrayList<>(Arrays.asList(root.val)));
            if (root.children != null) {
                Queue<Node> levelQueue = new ArrayDeque<>();
                for (Node child: root.children) {
                    levelQueue.offer(child);
                }
                traverse(levelQueue, totalList);
            }
        }
        return totalList;
    }

    private void traverse(Queue<Node> levelQueue, List<List<Integer>> totalList) {
        if (levelQueue.isEmpty()) {
            return;
        }
        List<Integer> levelList = new ArrayList<>();
        Queue<Node> childLevelQueue = new ArrayDeque<>();
        while (!levelQueue.isEmpty()) {
            Node currentNode = levelQueue.poll();
            levelList.add(currentNode.val);
            if (currentNode.children != null) {
                for (Node child: currentNode.children) {
                    childLevelQueue.offer(child);
                }
            }
        }
        totalList.add(levelList);

        traverse(childLevelQueue, totalList);

    }
}
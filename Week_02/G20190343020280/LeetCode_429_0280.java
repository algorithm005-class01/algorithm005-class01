//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
//
// 例如，给定一个 3叉树 :
//
//
//
//
//
//
//
// 返回其层序遍历:
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
//
//
//
//
// 说明:
//
//
// 树的深度不会超过 1000。
// 树的节点总数不会超过 5000。
// Related Topics 树 广度优先搜索


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
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
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList();
        if (root==null) {
            return result;
        }
        List<Node> nodes = new ArrayList<Node>();
        nodes.add(root);
        levelOrder(nodes, result);
        return result;
    }

    private void levelOrder (List<Node> nodeList, List<List<Integer>> list) {
        List<Integer> curLevel = new ArrayList<Integer>();
        List<Node> nextLevel = new ArrayList<Node>();
        for (Node node : nodeList) {
            curLevel.add(node.val);
            if (node.children!=null) {
                for (Node child : node.children) {
                    if (child != null) {
                        nextLevel.add(child);
                    }
                }
            }
        }
        list.add(curLevel);
        if (nextLevel.size()>0) {
            levelOrder(nextLevel, list);
        }
    }

    private List<List<Integer>> levelOrderByLoop (Node root) {
        List<List<Integer>> result = new ArrayList();
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> curLevel = new ArrayList<Integer>();
            int curSize = queue.size();
            for (int i = curSize; i > 0; i--) {
                Node node = queue.poll();
                if (node != null) {
                    curLevel.add(node.val);
                    if (node.children != null) {
                        for (Node child : node.children) {
                            if (child != null) {
                                queue.add(child);
                            }
                        }
                    }
                }
            }
            result.add(curLevel);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

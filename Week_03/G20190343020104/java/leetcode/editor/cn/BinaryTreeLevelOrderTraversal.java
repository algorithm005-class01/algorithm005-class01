//给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索

package leetcode.editor.cn;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
        System.out.println(solution.levelOrder(TreeNode.getTestData()));
    }


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();

        /**
         * def bfs(graph,start,end):
         * queue = []
         * queue.append([start])
         * visited.add(start)
         * while queue:
         * node = queue.pop()
         * visited.add(node)
         * process(node)
         * nodes = generate_related_nodes(node)
         * queue.push(nodes)
         *
         * @param root
         * @return
         */
        public List<List<Integer>> levelOrder(TreeNode root) {
            bfs(root, root, null);
            return result;
        }

        public void bfs(TreeNode root, TreeNode start, TreeNode end) {
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.add(start);
            int level = 0;
            while (!queue.isEmpty()) {
                result.add(new ArrayList<>());
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.pop();
                    System.out.println(level + ": " + node.val);
                    result.get(level).add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                level++;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
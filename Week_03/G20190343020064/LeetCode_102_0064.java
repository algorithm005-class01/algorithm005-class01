package G20190343020064;

import java.util.*;

/**
 * <p>
 * 二叉树的层次遍历
 * </p>
 *
 * @author mingke.yan@hand-china.com 2020-01-05 10:42 上午
 */
public class LeetCode_102_0064 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        deep(root,list,0);
        return list;
    }

    public void deep(TreeNode root, List<List<Integer>> list, int level) {
        if (root == null) {
            return;
        }
        if (level > list.size() - 1) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.val);
        deep(root.left, list, level + 1);
        deep(root.right, list, level + 1);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 广度优先方式
     * 使用队列 先进先出的方式
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> queue = new LinkedList<>();
        int level = 0;
        queue.add(root);
        while (!queue.isEmpty()){
            list.add(new ArrayList<>());
            int size = queue.size();
            //===============================================================================
            //  这里需要提前记录队列长度，因为下面会添加，长度会变
            //  然后用先进先出的方式，保证该for循环只遍历出当前层的数据加入到结果中
            //  然后将不为空的子节点加入到队列
            //===============================================================================
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                list.get(level).add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            level += 1;
        }
        return list;
    }



}

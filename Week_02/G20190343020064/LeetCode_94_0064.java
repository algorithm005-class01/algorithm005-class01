package G20190343020064;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 二叉树的中序遍历
 * </p>
 *
 * @author mingke.yan  2019-12-20 3:07 下午
 */
public class LeetCode_94_0064 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root,list);
        return list;
    }

    public void traversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        traversal(root.left, list);
        list.add(root.val);
        traversal(root.right, list);
    }



}

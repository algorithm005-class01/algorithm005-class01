package G20190343020064;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 二叉树的前序遍历
 * </p>
 *
 * @author mingke.yan  2019-12-20 3:23 下午
 */
public class LeetCode_144_0064 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root,list);
        return list;
    }

    public void traversal(TreeNode root,List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        traversal(root.left,list);
        traversal(root.right,list);
    }

}

import java.util.LinkedList;
import java.util.List;

public class LeetCode_94_0004 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new LinkedList<>();
        inorder(resultList, root);
        return resultList;
    }

    private void inorder(List<Integer> list, TreeNode root) {
        if (root != null) {
            inorder(list, root.left);
            list.add(root.val);
            inorder(list, root.right);
        }
    }
}

package week02;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 二叉树的前序遍历.
 *
 * @author Wengy
 * @since JDK 1.8
 * @since 1.0.0
 */
public class LeetCode_144_0314 {
  
  public List<Integer> preorderTraversal(TreeNode root) {
    
    List<Integer> list = new ArrayList<>();
    if(root==null) {
      return list;
    }
    
    list.add(root.val);
    list.addAll(preorderTraversal(root.left));
    list.addAll(preorderTraversal(root.right));
    
    return list;
    
  }
  
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

}
package week02;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: 二叉树的中序遍历.
 *
 * @author Wengy
 * @since JDK 1.8
 * @since 1.0.0
 */
public class LeetCode_94_0314 {
  
  public List<Integer> inorderTraversal(TreeNode root) {
    
    List<Integer> list = new ArrayList<>();
    if(root==null) {
      return list;
    }
    
    List<Integer> leftList = inorderTraversal(root.left);
    List<Integer> rightList = inorderTraversal(root.right);
    if(leftList!=null){
      list.addAll(leftList);
    }
    if(root!=null) {
      list.add(root.val);
    }
    
    if(rightList!=null) {
      list.addAll(rightList);
    }
    
    return list;
  }
  
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

}
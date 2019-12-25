package week02;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: 二叉树的最近公共祖先.
 *
 * @author Wengy
 * @since JDK 1.8
 * @since 1.0.0
 */
public class LeetCode_236_0314 {
  
  
  
  
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    Deque<TreeNode> deque1 = new LinkedList<>();
    Deque<TreeNode> deque2 = new LinkedList<>();
    dfsRecursion(root, p, deque1);
    dfsRecursion(root, q, deque2);
    TreeNode resultNode = null;
    
    int m1 = deque1.size();
    int m2 = deque2.size();
    System.out.println(m1);
    System.out.println(m2);
    
    while (true) {
      if(m1==m2) {
        if(deque1.peekFirst().val==deque2.peekFirst().val) {
          resultNode = deque1.peekFirst();
          break;
        }
        deque1.pollFirst();
        deque1.pollFirst();
      }
      if(m1>m2){
        deque1.pollFirst();
      }
      if(m1<m2){
        deque2.pollFirst();
      }
    }
    return resultNode;
    
  }
  
  private void dfsRecursion(TreeNode treeNode, TreeNode target, Deque<TreeNode> deque) {
    
    if(treeNode==null) {
      deque.removeAll(deque);
      return;
    }
    
    if(treeNode.val==target.val) {
      System.out.println(deque.size());
      return;
    }
    deque.offerFirst(treeNode);
    
    
    dfsRecursion(treeNode.left, target, deque);
    dfsRecursion(treeNode.right, target, deque);
    
  }
  
  public static void main(String[] args) {
  
    //System.out.println(combine(4,2));
    
    
  }
  
   public class TreeNode {
     int val;
     TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  
}

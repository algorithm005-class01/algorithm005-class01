package work02;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List list = new ArrayList<Integer>();
        inorder(root,list);
        return list;
    }
    public static void inorder(TreeNode root , List list){
        if(root!=null){
            inorder(root.left,list);
            list.add(root.val);
            inorder(root.right,list);
        }
    }
}
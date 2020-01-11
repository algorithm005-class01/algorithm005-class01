package week002;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;


/*
给定一个二叉树，返回它的 前序 遍历。

 示例:

输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [1,2,3]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */

public class Leetcode_144_0182 {
    public List<Integer> preorderTraversal(TreeNode root) {
    	
    	List<Integer> result = new ArrayList<Integer>();

    	helper(root, result);
        
    	return result;
    }
    
    void helper(TreeNode root, List<Integer> result) {
    	if (root == null) {
    		return;
    	}
    	
    	result.add(root.val);
    	
    	helper(root.left, result);

    	helper(root.right, result);
        
    	return;
    }
    
    public List < Integer > preorderTraversal2(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        Stack < TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
        	
            res.add(curr.val);
            
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();

            curr = curr.right;
        }
        return res;
    }

	
    /*
	public static void main(String args[]) {

		//System.out.println(isAnagram("anagram", "nagaram"));
		System.out.println(isAnagram("sdfs", "dsfw"));
		
		//System.out.println(isAnagram("anagram", "nagaram"));
		//System.out.println(isAnagram("rat", "car"));

	}
	*/
}

package week002;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;


/*
给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-anagram
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class Leetcode_94_183 {
    public List<Integer> inorderTraversal(TreeNode root) {
    	
    	List<Integer> result = new ArrayList<Integer>();

    	helper(root, result);
        
    	return result;
    }
    
    void helper(TreeNode root, List<Integer> result) {
    	if (root == null) {
    		return;
    	}
    	
    	helper(root.left, result);
    	
    	result.add(root.val);
    	
    	helper(root.right, result);
        
    	return;
    }
    
    public List < Integer > inorderTraversal2(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        Stack < TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
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

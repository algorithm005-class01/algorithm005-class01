package com.demo.test.leetcode;

import com.demo.test.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树层次遍历
 *
 * TODO
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

 例如:
 给定二叉树: [3,9,20,null,null,15,7],

     3
     / \
     9  20
        /  \
       15   7
 返回其层次遍历结果：

 [
 [3],
 [9,20],
 [15,7]
 ]

 * @author houyujia
 * @since 2019/12/29
 */
public class binaryTree_level_order_102 {
    public static void main(String[] args) {
        TreeNode node =new TreeNode(3);
        node.left=new TreeNode(9);
        node.right=new TreeNode(20);
        node.right.left=new TreeNode(15);
        node.right.right=new TreeNode(7);

        System.out.println(method1(node));

    }

    /**
     * 广度优先
     * @param root
     * @return
     */
    public static List<List<Integer>> method1(TreeNode root) {


        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //先将第一层 放入queue
        queue.add(root);

        while(!queue.isEmpty()){
            int count = queue.size();
            List<Integer> list = new ArrayList<Integer>();

            while(count > 0){
                //取出queue中的最先进去的node 放入list
                TreeNode node = queue.poll();

                list.add(node.val);

                //再放下一层到queue中
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);

                count--;
            }
            //每加完一层  放一个list到结果中
            res.add(list);
        }
        return res;
    }
}

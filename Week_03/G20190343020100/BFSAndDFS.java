package com.algorithm.week03;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONType;

import java.util.*;

public class BFSAndDFS {

//
// 例如:
//给定二叉树: [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//


    //static 不考虑并发安全问题，只是偷懒方便main方法测试
    static List<Integer> list = new ArrayList<>();
    static Set<TreeNode> visited = new HashSet<>();
    static TreeNode root = new TreeNode(3);

    public BFSAndDFS() {
        TreeNode _2left = new TreeNode(9);
        TreeNode _2right = new TreeNode(20);

        TreeNode _3_l_l = new TreeNode(11);
        TreeNode _3_l_r = new TreeNode(12);


        TreeNode _3_r_l = new TreeNode(15);
        TreeNode _3_r_r = new TreeNode(7);

        TreeNode _4_l_r_l = new TreeNode(13);
        TreeNode _5_l_r_l_l = new TreeNode(14);

        root.left = _2left;
        root.right = _2right;

        _2left.left = _3_l_l;
        _2left.right = _3_l_r;

        _2right.left = _3_r_l;
        _2right.right = _3_r_r;

        _3_l_r.left = _4_l_r_l;
        _4_l_r_l.left = _5_l_r_l_l;
    }


    //广度优先
        public void levelOrderBFS(TreeNode root) {
            //维护一个队列
            Deque<TreeNode> queue = new LinkedList<>();
            queue.addLast(root);

            while (!queue.isEmpty()) {
                TreeNode node = queue.pollFirst();

                //处理
                list.add(node.val);

                //获取层次所有节点
                if (node.left != null)
                    queue.addLast(node.left);
                if (node.right != null)
                    queue.addLast(node.right);
            }

            System.out.println(JSON.toJSONString(list));
        }


        //深度优先
        public void levelOrderDFS(TreeNode node,Set<TreeNode> visited) {
//            if (visited.contains(node))
//                return;

            visited.add(node);
            list.add(node.val);

            List<TreeNode> children = new ArrayList<>();
            if (node.left != null)
                children.add(node.left);
            if (node.right != null)
                children.add(node.right);

            for (TreeNode nextNode:children) {
                if (!visited.contains(nextNode))
                    levelOrderDFS(nextNode,visited);
            }
        }


    public static void main(String[] args) {
        BFSAndDFS test = new BFSAndDFS();
        test.levelOrderDFS(root,visited);
        System.out.println(JSON.toJSONString(list));

    }

    @JSONType(includes={"val"})
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

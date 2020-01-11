<?php
/**
 * User: gaofei
 * Date: 2019/12/26
 * Time: 23:04
 * Desc: 二叉树的层次遍历
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *   3
    / \
    9  20
    /  \
    15   7
 *
 * 返回其层次遍历结果：

    [
    [3],
    [9,20],
    [15,7]
    ]
 *
 * Link: https://leetcode-cn.com/problems/binary-tree-level-order-traversal/submissions/
 */
/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     public $val = null;
 *     public $left = null;
 *     public $right = null;
 *     function __construct($value) { $this->val = $value; }
 * }
 */
class Solution {

    /**
     * @param TreeNode $root
     * @return Integer[][]
     */
    function levelOrder($root) {
        if ($root == null) return [];
        $res = [];
        $this->recursion($root,0,$res);
        return $res;
    }
    function recursion($node,$level,&$res) {
        if (count($res) == $level) $res[$level] = [];
        array_push($res[$level],$node->val);
        if ($node->left != null) $this->recursion($node->left,$level + 1,$res);
        if ($node->right != null) $this->recursion($node->right,$level + 1,$res);
    }
}
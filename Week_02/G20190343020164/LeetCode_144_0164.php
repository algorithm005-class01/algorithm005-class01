<?php
/**
 * Created by PhpStorm.
 * User: gaofei
 * Date: 2019/12/19
 * Time: 13:04
 * Title: 二叉树的中序遍历
 * Desc: 给定一个二叉树，返回它的中序 遍历。
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
class TreeNode {
    public $val = null;
    public $left = null;
    public $right = null;
    function __construct($value) { $this->val = $value; }
}
class Solution {

    /**
     * @param TreeNode $root
     * @return Integer[]
     * 中序(In-order):左-根-右
     * ---------------------------------------
     * Way 1----------------一开始就进入牛角尖,开始了人肉递归
     * 循环
     * 第二个值比第一个值小,则为做
     * ---------------------------------------
     */
    function inorderTraversal1($root) {
        $res = [];
        $this->helper($root,$res);
        return $res;
    }
    function helper($root,&$res){
        if ($root == null) return;
        $this->helper($root->left,$res);
        $res[] = $root->val;
        $this->helper($root->right,$res);
    }

    function inorderTraversal($root) {
        if(!$root->val) {
            return [];
        }

        $res = $this->inorderTraversal($root->left);
        $res []= $root->val;
        $res = array_merge($res, $this->inorderTraversal($root->right));

        return $res;
    }
}
$Solution = new Solution();
$TreeNode = new TreeNode(2);
$TreeNode->left = new TreeNode(1);
$TreeNode->right = new TreeNode(3);
$TreeNode->right->left = new TreeNode(4);
$result = $Solution->inorderTraversal($TreeNode);
print_r($TreeNode);
print_r($result);

<?php
/**
 * User: gaofei
 * Date: 2019/12/19
 * Time: 23:43
 * Title: 二叉树的💰前序遍历
 * Desc: 给定一个二叉树，返回它的前序 遍历。
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
     * 前序(In-order):根-左-右
     * ---------------------------------------
     * Way 1
     * ---------------------------------------
     */
    function inorderTraversal1($root) {
        $res = [];
        $this->helper($root,$res);
        return $res;
    }
    function helper($root,&$res){
        if ($root == null) return;
        $res[] = $root->val;
        $this->helper($root->left,$res);
        $this->helper($root->right,$res);
    }

    function inorderTraversal($root) {
        if(!$root->val) {
            return [];
        }

        $res []= $root->val;
        $res = $this->inorderTraversal($root->left);
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

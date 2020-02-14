<?php
/**
 * User: gaofei
 * Date: 2020/2/1
 * Time: 09:36
 * Desc:
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
        print_r($res);
        array_push($res[$level],$node->val);
        if ($node->left != null) $this->recursion($node->left, $level + 1, $res);
        if ($node->right != null) $this->recursion($node->right, $level + 1,$res);
    }
}

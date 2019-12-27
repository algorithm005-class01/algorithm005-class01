<?php
/**
 * User: gaofei
 * Date: 2019/12/20
 * Time: 23:05
 * Title:  括号生成
 * Desc:
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 */
class Solution {

    public $arrayList = [];

    /**
     * @param Integer $n
     * @return String[]
     * ------------------------------------------------
     * ()    对于递归,一开始就进入了人肉递归,困扰了好几天
     * left 随便加 只要不超标
     * right 只能加到left之后 即 left>right
     * ------------------------------------------------
     */
    function generateParenthesis($n) {
        //共2n个地方,优化后,左右控制分开,所以共$n即可
        $this->helper(0,0,$n,"");
        return $this->arrayList;

    }
    function helper($left,$right,$n,$s) {
        if ($left == $n && $right == $n) {
            $this->arrayList[] = $s;
            return ;
        }
        if ($left < $n) $this->helper($left +1,$right,$n,$s . "(");
        if ($left > $right) $this->helper($left,$right +1,$n,$s . ")");
    }
}
$Solution = new Solution();
$result = $Solution->generateParenthesis(3);
print_r($Solution->arrayList);
<?php
/**
 * User: gaofei
 * Date: 2020-02-01
 * Time: 09:31
 * Title:  爬楼梯
 * Desc:
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 */
class Solution {

    /**
     * @param Integer $n
     * @return Integer
     * -------------------------------------------------------
     * 之前的课程里就有这道题,有点懵逼的感觉
     * ##斐波拉契数列
     * 先简单的推导一下
     * n个台阶----------走法------------共几种
     * n=1         一步                 1
     * n=2        1-1、2                2
     * n=3        1-1-1、1-2、2-1       3
     * 推导公式  到达最后一个台阶  只能要么一个台阶  要么两个台阶
     * f(n) = f(n-1) + f(n-2)
     *
     * 看解题说是递归法,没看到递归的特征,隐隐有那么点感觉,只是还不是很透彻
     *
     *
     * -------------------------------------------------------
     */
    function climbStairs($n) {
        $numArr = [1=>1,2=>2];
        if ($n <= 2) return $numArr[$n];
        for ($i = 3;$i <= $n; $i++) {
            $numArr[$i] = $numArr[$i - 1] + $numArr[$i - 2];
        }
        return $numArr[$n];
    }
}
$Solution = new Solution();
$result = $Solution->climbStairs($strs);
print_r($result);
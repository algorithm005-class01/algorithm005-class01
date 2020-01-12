<?php
/**
 * User: gaofei
 * Date: 2020/1/12
 * Time: 15:35
 * Desc:
 */
class Solution {

    /**
     * @param Integer[][] $grid
     * @return Integer
     */
    function minPathSum($grid) {

        //计算几行几列
        $m = count($grid);
        $n = count($grid[0]);

        $dp = $grid;
        for ($i = 1; $i < $m; $i++) $dp[$i][0] += $dp[$i - 1][0];
        for ($i = 1; $i < $n; $i++) $dp[0][$i] += $dp[0][$i - 1];
        for ($i = 1; $i < $m; $i++) {
            for ($j = 1; $j < $n; $j++) {
                $dp[$i][$j] = min($dp[$i - 1][$j],$dp[$i][$j - 1]) + $grid[$i][$j];
            }
        }
        return $dp[$m - 1][$n - 1];

    }
}
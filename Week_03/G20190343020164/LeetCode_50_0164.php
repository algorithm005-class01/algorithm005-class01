<?php
/**
 * User: gaofei
 * Date: 2019/12/23
 * Time: 23:04
 * Desc:
 */

class Solution {

    /**
     * @param Float $x
     * @param Integer $n
     * @return Float
     * --------------------------------------
     * 暴力求解
     * 超时
     * --------------------------------------
     */
    function myPow1($x, $n) {
        if ($n < 0) {
            $x = 1/$x;
            $n = -$n;
        }
        //暴力求解
        $result = 1;
        $tmp_x = $n%2 == 1 ? $x : 1;
        $tmp_n = $n%2 == 1 ? ($n -1)/2 : $n/2;
        for ($i=0;$i<$tmp_n;$i++) {
            $result *= $x;
        }
        $result = $result * $result*$tmp_x;
        return $result;

    }

    /**
     * @param $x
     * @param $n
     * ----------------------------
     * 递归
     * ----------------------------
     */
    function fastPow($x,$n) {
        if ($n == 0) return 1;
        $half = $this->fastPow($x,$n/2);
        return $n % 2 == 0 ? $half * $half : $half * $half * $x;
    }

    /**
     * @param $x
     * @param $n
     * @return float|int
     * -------------------------------------------
     * 分治
     * 2^10 --> 2^5*2^5 --> 2^2*2^2*2
     * -------------------------------------------
     */
    function myPow2($x, $n) {
        if ($n < 0) {
            $x = 1/$x;
            $n = -$n;
        }
        $result = $this->fastPow($x,$n);

        return $result;

    }

    /**
     * @param Float $x
     * @param Integer $n
     * @return Float
     * -----------------------------------
     * 国际站中看到的,感觉比之前的递归更好一些
     * -----------------------------------
     */
    function myPow($x, $n) {
        if (!$n) return 1;
        if ($n < 0) return 1 / self::myPow($x,-$n);
        if ($n % 2) return $x * self::myPow($x,$n / 2);
        return self::myPow($x * $x,$n / 2);
    }
}
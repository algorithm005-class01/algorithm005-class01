<?php
/**
 * User: gaofei
 * Date: 2020/1/12
 * Time: 15:35
 * Desc:
 */
class Solution {

    /**
     * @param String $text1
     * @param String $text2
     * @return Integer
     */
    function longestCommonSubsequence($text1, $text2) {
        //如果两个字符串有一个为空
        if ($text1 == '' || $text2 == '') return 0;
        //计算两个字符串的长度
        $s1 = strlen($text1);
        $s2 = strlen($text2);
        $dp = [];
        for ($i = 0; $i <= $s1; $i++) {
            for ($j=0; $j <= $s2; $j++) {
                $dp[$i][$j] = 0;
            }
        }
        for ($i = 1; $i <= $s1; $i++) {
            for ($j = 1; $j <= $s2; $j++) {
                //如果尾端相同
                if ($text1[$i - 1] == $text2[$j - 1]) {
                    $dp[$i][$j] = 1 + $dp[$i - 1][$j - 1];
                } else {
                    $dp[$i][$j] = max($dp[$i - 1][$j], $dp[$i][$j - 1]);
                }
            }
        }
        return $dp[$s1][$s2];
    }
}
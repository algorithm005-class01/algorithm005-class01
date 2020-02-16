<?php
/**
 * User: gaofei
 * Date: 2020/2/8
 * Time: 21:30
 * Desc:
 */
class Solution {

    /**
     * @param Integer $n
     * @return Boolean
     */
    function isPowerOfTwo($n) {
        return $n > 0 && ($n & ($n -1)) == 0;
    }
}
<?php
/**
 * User: gaofei
 * Date: 2020/2/16
 * Time: 21:30
 * Desc:
 */
class Solution {

    /**
     * @param String $s
     * @return String
     */
    function reverseWords($s) {
        $s = trim($s);
        $s2="";
        $j = strlen($s);
        for($i=$j-1;$i>0;$i--){
            if($s[$i] === ' '){
                $s2.=substr($s,$i+1,$j-$i-1).' ';
                while($s[$i-1]===' ') $i--;
                $j=$i;
            }
        }
        $s2.=substr($s,$i,$j);
        return $s2;
    }
}
<?php
/**
 * User: gaofei
 * Date: 2020/2/8
 * Time: 21:30
 * Desc:
 */
class Solution {

    /**
     * @param Integer[][] $intervals
     * @return Integer[][]
     */
    function merge($intervals) {
        if (count($intervals) < 1) return [];
        sort($intervals);//先确保集合是有序的
        $j = 0;
        $new_arr[$j] = $intervals[0];
        for ($i = 1;$i < count($intervals);$i++) {
            $start = $intervals[$i][0];
            $end   = $intervals[$i][1];
            if ($start <= $new_arr[$j][1]) {
                //可以合并
                $new_arr[$j] = [$new_arr[$j][0],max($new_arr[$j][1],$end)];
            } else {
                $j++;
                $new_arr[$j] = $intervals[$i];
            }
        }
        return $new_arr;
    }
}
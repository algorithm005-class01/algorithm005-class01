<?php
/**
 * Created by PhpStorm.
 * User: gaofei
 * Date: 2019/12/17
 * Time: 23:05
 * Title: 字母异位词分组
 * Desc: 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 */
class Solution {
    /**
     * @param String[] $strs
     * @return String[][]
     * -------------------------------------
     * way 1: 暴力求解
     * 1、循环数组 字母拆开排序
     * 2、以排序后的字符为key 的二维数组,值为原字符循序
     * 3、返回即可
     * -------------------------------------
     *
     */
    function groupAnagrams($strs) {
        $count = count($strs);
        if (!$count) return [];
        $str_arr = [];
        foreach ($strs as $k=>$v) {
            $key_arr = str_split($v);
            asort($key_arr);
            $str_arr[implode('',$key_arr)][] = $v;
        }
        return $str_arr;

    }
}
$Solution = new Solution();
$strs = ["eat", "tea", "tan", "ate", "nat", "bat"];
$result = $Solution->groupAnagrams($strs);
print_r($result);
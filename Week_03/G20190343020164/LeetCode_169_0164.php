<?php
/**
 * User: gaofei
 * Date: 2019/12/23
 * Time: 23:04
 * Desc: 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * Link: https://leetcode-cn.com/problems/majority-element/submissions/
 */
class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function majorityElement($nums) {
        //暴力解法
        $result = [];
        for ($i=0;$i<count($nums);$i++) {
            if(isset($result[$nums[$i]])) {
                $result[$nums[$i]]++;
            } else {
                $result[$nums[$i]] = 1;
            }
        }
        return array_search(max($result),$result);

    }

}
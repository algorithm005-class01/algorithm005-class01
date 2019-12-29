<?php
/**
 * Created by PhpStorm.
 * User: gaofei
 * Date: 2019/12/10
 * Time: 20:26
 * LeetCode_题号_学号.语言后缀(.js|.java|.py|.php)
 * LeetCode 26题 删除排序数组中的重复项
 */
class Solution {

    /**
     * 删除排序数组中的重复项 方法一
     * @param Integer[] $nums
     * @return Integer
     * ------------------------------------
     * 1、通过php函数array_unique
     * 2、count统计元素个数
     * ------------------------------------
     */
    function removeDuplicates1(&$nums) {
        $nums = array_unique($nums);
        return count($nums);
    }

    /**
     * 方法二
     * @param Integer[] $nums
     * @return Integer
     * --------------------------------------
     * 先统计数组长度$len = $count = count($nums)
     * 如果长度 小于 2 直接返回$count
     * 一个for循环
     * 从第一个元素开始,后一个跟前一个比较,如果重复就unset掉,数组长度减一
     * 否则比较使用的下表$j = $i
     * --------------------------------------
     *
     * 思考:for循环比array_unique 函数耗时小
     */
    function removeDuplicates(&$nums) {
        $len = $count = count($nums);
        if ($count < 2) return $count;
        for ($i=1,$j=0;$i<$count;$i++) {
            if ($nums[$i] == $nums[$j]) {
                unset($nums[$i]);
                $len--;
            } else {
                $j = $i;
            }
        }
        return $len;

    }


}
$Solution = new Solution();
$nums = [0,0,1,1,1,2,2,3,3,4];
$return = $Solution->removeDuplicates($nums);
echo $return;
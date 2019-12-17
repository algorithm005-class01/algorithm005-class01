<?php
/**
 * Created by PhpStorm.
 * User: gaofei
 * Date: 2019/12/10
 * Time: 00:19
 * LeetCode_题号_学号.语言后缀(.js|.java|.py|.php)
 * LeetCode 1题 两数之和
 */
class Solution {

    /**
     * Desc 两数之和
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，
     * 并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     * -------------------------------------
     * 1、统计数组长度,小于2 则返回空
     * 2、foreach循环 $nums
     * 3、$tmp = $target - 当前数
     * 4、通过in_array()看数组中是否有$tmp
     * 5、如果存在 array_search()得出所需值对应的key 并且当前$k 不等于 当前值对应key
     * 6、即可得出两个key值
     * -------------------------------------
     */
    function twoSum1($nums, $target) {
        if(count($nums) < 2) {
            return ;
        }
        //先循环一遍
        foreach ($nums as $k=>$v) {
            $tmp = $target - $v;
            if (in_array($tmp,$nums,true)) {
                $k2 = array_search($tmp,$nums);
                if($k == $k2) continue;
                return [$k,$k2];
            }
        }
    }

    /**
     * Desc 两数之和
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，
     * 并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     * -------------------------------------
     * 1、设置一个空数组$numArr
     * 2、foreach循环 $nums
     * 3、$tmp = $target - 当前数
     * 4、判断新设置的$numArr数组中 是否存在键为$tmp,
     *    如果不存在,则将此值存入$numArr  值为key  key为值 也就是key val对调一下
     *    然后跳出当次循环,继续下一次循环
     * 5、如果存在,那么$numArr[$tmp]是存在的,
     * 6、
     * -------------------------------------
     */
    function twoSum($nums, $target) {
        $numArr = [];
        foreach ($nums as $key=>$val) {
            $tmp = $target - $val;
            if(!isset($numArr[$tmp])) {
                $numArr[$val] = $key;
                continue;
            }
            return [$numArr[$tmp],$key];
        }
    }
}
$Solution = new Solution();
$nums = [2, 7, 11, 15];
$target = 9;
$return = $Solution->twoSum($nums,$target);
print_r($return);
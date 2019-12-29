<?php
/**
 * User: gaofei
 * Date: 2019/12/28
 * Time: 23:04
 * Desc:
 * Link: https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * 你可以假设数组中不存在重复的元素。

    你的算法时间复杂度必须是 O(log n) 级别。

    示例 1:

    输入: nums = [4,5,6,7,0,1,2], target = 0
    输出: 4
    示例 2:

    输入: nums = [4,5,6,7,0,1,2], target = 3
    输出: -1

 */
class Solution {

    function searchRecursion($nums, $low,$high , $target) {
        //终止条件
        if ($low > $high) return -1;

        $mid = $low + (($high - $low) >> 1);
        if ($nums[$mid] == $target) return $mid;
        if ($nums[$low] <= $nums[$mid]) {
            //前半段有序
            if ($target < $nums[$mid] && $target >= $nums[$low]) {
                return $this->searchRecursion($nums, $low, $mid - 1, $target);
            } else {
                return $this->searchRecursion($nums, $mid + 1, $high, $target);
            }
        } else {
            if ($target > $nums[$mid]  && $target <= $nums[$high]) {
                return $this->searchRecursion($nums, $mid+1, $high, $target);
            } else {
                return $this->searchRecursion($nums, $low, $mid-1, $target);
            }
        }
    }

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer
     */
    function search($nums, $target) {
        if (count($nums) == 0) return -1;
        if (count($nums) == 1) return $nums[0] == $target ? 0 : -1;
        //递归
        //return $this->searchRecursion($nums, 0, count($nums) - 1, $target);
        //非递归方式实现
        $low = 0;
        $high = count($nums) - 1;
        while ($low <= $high) {
            $mid = floor($low +  (($high - $low)>>1));//防止两数相加超过限制,除以2使用位运算更快
            if ($nums[$mid] == $target) return $mid;
            if ($nums[$low] <= $nums[$mid]) {
                //前半段有序
                if ($target < $nums[$mid] && $target >= $nums[$low]) {
                    $high = $mid - 1;
                } else {
                    $low = $mid + 1;
                }
            } else {
                if ($target > $nums[$mid]  && $target <= $nums[$high]) {
                    $low = $mid + 1;
                } else {
                    $high = $mid - 1;
                }
            }
        }
        return -1;
    }
}
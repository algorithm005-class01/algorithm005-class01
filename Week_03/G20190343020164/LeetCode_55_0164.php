<?php
/**
 * User: gaofei
 * Date: 2019/12/28
 * Time: 23:04
 * Desc:给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 * Link: https://leetcode-cn.com/problems/jump-game/
 * 示例 1:
    输入: [2,3,1,1,4]
    输出: true
    解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
    示例 2:

    输入: [3,2,1,0,4]
    输出: false
    解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
class Solution {

    /**
     * @param Integer[] $nums
     * @return Boolean
     */
    function canJump($nums) {
        //贪心算法，从后往前的方式
        $last_pos = count($nums) - 1;
        for ($i=count($nums) - 1;$i >= 0;$i--) {
            if ($nums[$i] + $i >= $last_pos) {
                $last_pos = $i;
            }
        }
        //return $last_pos == 0 ? true : false;
        return $last_pos == 0;//看题解中的这种方式反而更快一些
    }
}
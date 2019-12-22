<?php
/**
 * Created by PhpStorm.
 * User: gaofei
 * Date: 2019/12/12
 * Time: 19:14
 * LeetCode_题号_学号.语言后缀(.js|.java|.py|.php)
 * LeetCode 283题 移动零
 */
class Solution {

    /**
     * Desc 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * @param Integer[] $nums
     * @return NULL
     * 说明:
     * 1、必须在原数组上操作，不能拷贝额外的数组。
     * 2、尽量减少操作次数。
     * ------------------------------------------------
     * 1、计算数组长度为$j  $count,如果长度小于1,返回空
     * 2、for循环,如果当前 元素 == 0 ,则key从$j开始追加值为0 并且$j++,unset销毁当前值
     * 3、循环一遍后 return $nums
     * ------------------------------------------------
     */
    function moveZeroes1(&$nums) {
        $j = $count = count($nums);
        if ($count < 1) {
            return [];
        }

        for ($i=0;$i<$count;$i++) {
            if ($nums[$i] == 0) {
                $nums[$j] = 0;
                $j++;
                unset($nums[$i]);
            }
        }
        return $nums;
    }

    /**
     * Desc 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * @param Integer[] $nums
     * @return NULL
     * 说明:
     * 1、必须在原数组上操作，不能拷贝额外的数组。
     * 2、尽量减少操作次数。
     * ------------------------------------------------
     * 此方法类似上面一种
     * 1、for循环 如果当前值为0,unset掉当前值
     * 2、并且通过array_push函数给$nums 后面追加0
     * ------------------------------------------------
     */
    function moveZeroes2(&$nums) {
        for ($i=0;$i<count($nums);$i++) {
            if ($nums[$i] == 0) {
                unset($nums[$i]);
                array_push($nums,0);
            }
        }
    }

    /**
     * Desc 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * @param Integer[] $nums
     * @return NULL
     * 说明:
     * 1、必须在原数组上操作，不能拷贝额外的数组。
     * 2、尽量减少操作次数。
     * ------------------------------------------------
     * 此方法目前我看到的用时较少的方法
     * 1、统计数组长度$old_len
     * 2、通过array_filter() 过滤数组中的单元 函数去除掉0、null 等空值(array_filter会过滤掉任何值等于FALSE的值，也就是说  0值，空字符串，null，都会被过滤)
     * 3、通过array_values() 函数处理过滤后的结果
     * 4、统计过滤后数组长度
     * 5、通过原长度和新长度 计算后面需要补充几个0
     * 6、for循环 ,通过array_push()或者  不用内置函数 用key的形式 补充0
     * ------------------------------------------------
     */
    function moveZeroes(&$nums) {
        //计算数组元素个数
        $old_len = count($nums);

        //删除0 null等
        $nums = array_values(array_filter($nums));

        //计算后面需要几个0
        $new_len = count($nums);
        $zeroes_len = $old_len - $new_len;

        //如果需要补0
        if ($zeroes_len) {
            for ($i=0;$i<$zeroes_len;$i++) {
                array_push($nums,0);
                //$nums[$new_len + $i] = 0;
            }
        }
        return $nums;
    }
}
$Solution = new Solution();
$nums = [0,1,0,3,12];
$return = $Solution->moveZeroes($nums);
print_r($return);
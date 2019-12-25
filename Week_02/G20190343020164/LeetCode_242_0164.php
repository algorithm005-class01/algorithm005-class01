<?php
/**
 * Created by PhpStorm.
 * User: gaofei
 * Date: 2019/12/17
 * Time: 00:35
 * 有效的字母异位词
 * ------------------------------------------
 * 1、顾名思义,异位词就是字母出现的次数相同,顺序不同
 * 2、根据做题四件套,如果不知道需要确定意思,大小写是否要区分等等
 * ------------------------------------------
 */
class Solution {

    /**
     * @param String $s
     * @param String $t
     * @return Boolean
     * ----------------------------------------
     * @方法一:暴力解法
     * 1、字符排序
     * 2、对比是否相等
     * ----------------------------------------
     */
    function isAnagram($s, $t) {
        $arr_s = str_split($s);
        $arr_t = str_split($t);
        asort($arr_s);
        asort($arr_t);
        $str_s = implode('',$arr_s);
        $str_t = implode('',$arr_t);
        return $str_s == $str_t ? true : false;
    }

    /**
     * @param String $s
     * @param String $t
     * @return Boolean
     * ----------------------------------------
     * @方法二:半暴力解法
     * 1、计算字符串长度
     * 2、长度相等在 把第一个字符串分割成数组
     * 3、循环此数组,根据每个字符为key 变成二维数组统计
     * 4、在循环一次,根据key 判断在另一个字符中出现的次数
     * ----------------------------------------
     */
    function isAnagram2($s, $t) {
        $len_s = strlen($s);
        $len_t = strlen($t);
        if ($len_s == $len_t) {
            if ($len_s == 0) return true;
            $arr_s = str_split($s);
            $tmp = [];
            foreach ($arr_s as $v) {
                $tmp[$v][] = $v;
            }
            foreach ($tmp as $k=>$v) {
                if(count($tmp[$k]) != substr_count($t,$k)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * @param String $s
     * @param String $t
     * @return Boolean
     * ----------------------------------------
     * @方法三:函数解法
     * 1、计算字符串长度如果不相等则返回false
     * 2、长度相等 在把第一个字符串分割成数组str_split  ,通过array_count_values统计数组中所有的值 key 元素   value 元素次数
     * ----------------------------------------
     */
    function isAnagram3($s, $t) {
        if (strlen($s) != strlen($t)) {
            return false;
        }
        return array_count_values(str_split($s)) == array_count_values(str_split($t)) ? true : false;
    }

    /**
     * @param String $s
     * @param String $t
     * @return Boolean
     * ----------------------------------------
     * @方法四:自带函数
     * ----------------------------------------
     */
    function isAnagram4($s, $t) {
        if(strlen($s) != strlen($t)){              //判断两字符串长度是否一样
            return false;
        }

        $arr1 = array_count_values(str_split($s));//把字符串变成数组
        $arr2 = array_count_values(str_split($t));//并返回新数组键为字符，值为出现次数
        $length = count($arr1);
        $key = array_keys($arr1);                //获取所有键，并以新数组返回

        if($length != count($arr2))
            return false;
        for($i = 0; $i < $length; $i++){
            if($arr1[$key[$i]] != $arr2[$key[$i]])
                return false;
        }
        return true;
    }

    /**
     * @param String $s
     * @param String $t
     * @return Boolean
     * ----------------------------------------
     * @方法五:哈希表
     * ----------------------------------------
     */
    function isAnagram5($s, $t) {
        $hash = [];
        $count = strlen($s);
        $count2 = strlen($t);
        if ($count2!=$count) {
            return false;
        }
        for ($i=0;$i<$count;$i++) {
            if (!isset($hash[$s[$i]])) {
                $hash[$s[$i]] = 1;
            } else {
                $hash[$s[$i]]++;       //键为字符，出现一次，自增一次
            }

        }
        for ($i=0;$i<$count;$i++) {
            if(!isset($hash[$t[$i]]))
                return false;

            $hash[$t[$i]]--;
            if($hash[$t[$i]] < 0)
                return false;
        }
        return true;
    }
}
$Solution = new Solution();
$s = '';
$t = '';
$result = $Solution->isAnagram2($s, $t);
print_r($result);
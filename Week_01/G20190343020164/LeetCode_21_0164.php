<?php
/**
 * Created by PhpStorm.
 * User: gaofei
 * Date: 2019/12/14
 * Time: 23:11
 * LeetCode_题号_学号.语言后缀(.js|.java|.py|.php)
 * LeetCode 21题 合并两个有序链表
 */
/**
 * Definition for a singly-linked list.
 * class ListNode {
 *     public $val = 0;
 *     public $next = null;
 *     function __construct($val) { $this->val = $val; }
 * }
 */
class ListNode {
     public $val = 0;
     public $next = null;
     function __construct($val) { $this->val = $val; }
}

class Solution {

    /**
     * @param ListNode $l1
     * @param ListNode $l2
     * @return ListNode
     * -------------------------------------------------
     * 想暴力解决方法,没有思路
     * 1、实例化一个新链表
     * 2、赋值给$prev
     * 3、判断$l1  $l2  都不为空的时候才执行循环链表结点
     * 4、判断链表$l1 和 $l2 当前循环的val
     * 5、如果大于,则$prev->next = $l2 ,$l2等于next结点
     *    反之 $prev->next = $l1,$l1等于next结点,
     * 6、$prev = $prev->next
     *
     *
     * -------------------------------------------------
     */
    function mergeTwoLists1($l1, $l2) {
        //参考利利同学的写法
        $listNode = new ListNode(0);
        $prev = $listNode;
        $i = 0;
        while ($l1 != null && $l2 != null) {
            if ($l1->val > $l2->val) {
                $prev->next = $l2;
                $l2 = $l2->next;
            } else {
                $prev->next = $l1;
                $l1 = $l1->next;
            }
            $prev = $prev->next;
        }
        $prev->next = $l1 == null ? $l2 : $l1;
        return $listNode->next;

    }

    /**
     * 方法二
     * @param ListNode $l1
     * @param ListNode $l2
     * @return ListNode
     * -------------------------------------------------
     * 递归的思想
     * 1、先判断$l1 == null ,是则返回$l2
     * 2、判断$l2 == null ,是则返回$l1
     * 3、如果$l1->val < $l2->val  , 则$l1->next = 继续递归执行 $l1 变成了next结点 ,$l2不变
     * 4、反之$l2->next = 继续递归执行,$l1参数不变,$l2变为$l2->next
     * 5、一直到是其中一个链表含有另一链表的数据,返回
     * -------------------------------------------------
     */
    function mergeTwoLists($l1, $l2) {
        if ($l1 == null) {
            return $l2;
        } elseif ($l2 == null) {
            return $l1;
        } elseif ($l1->val < $l2->val) {
            $l1->next = $this->mergeTwoLists($l1->next, $l2);
            return $l1;
        } else {
            $l2->next = $this->mergeTwoLists($l1, $l2->next);
            return $l2;
        }
    }
}
$Solution = new Solution();
$l1 = new ListNode(1);
$l1->next = new ListNode(1);
$l1->next->next = new ListNode(5);
$l2 = new ListNode(1);
$l2->next = new ListNode(2);
$l2->next->next = new ListNode(6);

$return = $Solution->mergeTwoLists($l1,$l2);
echo '<pre>';
print_r($return);
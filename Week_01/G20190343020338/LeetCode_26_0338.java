
/**
给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

*/

import java.lang.reflect.Array;

class Solution {

    public static void main(String args[]) { 
        int[] numsArray = {0,0,1,1,1,2,2,3,3,4};
        int len = removeDuplicates(numsArray);
        System.out.println(len);
    }

    public static int removeDuplicates(int[] nums) {
        //数组判空处理
        if (nums.length == 0) return 0;
        //数组首项
        int i = 0;
        //从数组第二项开始遍历
        for (int j = 1; j < nums.length; j++) {
            //当前一项的值不等于后一项时
            if (nums[j] != nums[i]) {
                //后一项索引加加
                i++;
                //将前一项的值赋值给后一项
                nums[i] = nums[j];//交换位置
            }
        }
        return i + 1;//最终赋值交换完成数组项加一返回
    }
}
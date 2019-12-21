package com.zyh.test;

public class LeetCode_26_0004 {

    //已看题解，再进行更改的
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int i = 0;
        int j = 1;
        while (i < nums.length - 1 && j < nums.length) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
            j++;
        }
        j = ++i;
        while (j < nums.length) {
            nums[j] = 0;
            j++;
        }
        return i;
    }
}

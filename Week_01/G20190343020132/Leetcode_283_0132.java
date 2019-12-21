package org.azai.train.Week01;

public class Leetcode_283_0132 {
    //快慢指针，快指针枚举数组元素，慢指针标识元素该放的位置，如果快慢指针不一致，则交换快慢指针的元素
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0;i<nums.length;i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                if (i != index) {
                    nums[i] = 0;
                }
                index++;
            }
        }
    }
}

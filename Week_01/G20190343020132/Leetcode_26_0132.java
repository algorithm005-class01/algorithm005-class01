package org.azai.train.Week01;
//使用快慢指针
//快指针枚举数组中的元素，慢指针标识元素该放的位置
public class Leetcode_26_0132 {
    public int removeDuplicates(int[] nums) {
        if (nums==null||nums.length==0) return 0;
        int j = 0;
        for (int i = 0;i < nums.length;i++) {
            if(nums[i] != nums[j]){
                nums[++j] = nums[i];
            }
        }
        return j+1;
    }
}

package com.algorithm.week03;

public class LeetCode_33_0100 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        //边界
        int start = 0 , end = nums.length - 1;
        //二分 思想为左右夹逼法
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (nums[mid] == target) {
                return mid;
            }
            //前半部分有序,注意此处用小于等于
            if (nums[start] <= nums[mid]) {
                //target 在 前半
                if (target >= nums[start] && target < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            } else {
                if (target <= nums[end] && target > nums[mid])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode_33_0100 test = new LeetCode_33_0100();
        System.out.println(test.search(new int[]{4,5,6,7,0,1,2},0));
    }
}

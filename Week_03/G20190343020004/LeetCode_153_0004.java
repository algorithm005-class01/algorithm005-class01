package com.zyh.test.leetcode;

public class LeetCode_153_0004 {

    public int findMin(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int lo = 0;
        int hi = nums.length - 1;
        if (nums.length == 1 || nums[0] < nums[hi]) {
            return nums[0];
        }

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[0] < nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return nums[lo];
    }
}

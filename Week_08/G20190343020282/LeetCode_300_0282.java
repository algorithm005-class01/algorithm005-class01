package com.demo.test.leetcode;

/**
 * TODO
 *给定一个无序的整数数组，找到其中最长上升子序列的长度。

 示例:

 输入: [10,9,2,5,3,7,101,18]
 输出: 4
 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。

 * @author houyujia
 * @since 2020/2/16
 */
public class longest_increasing_subsequence_300 {


    /**
     * 方法一 暴力
     * @param nums
     * @return
     */
    public  int method1(int[] nums) {
        return lengths(nums, Integer.MIN_VALUE, 0);
    }
        public int lengths(int[] nums, int prev, int curpos) {
            if (curpos == nums.length) {
                return 0;
            }
            int istaken = 0;
            if (nums[curpos] > prev) {
                istaken = 1 + lengths(nums, nums[curpos], curpos + 1);
            }
            int nottaken = lengths(nums, prev, curpos + 1);
            return Math.max(istaken, nottaken);
        }


    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int method2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }


    }


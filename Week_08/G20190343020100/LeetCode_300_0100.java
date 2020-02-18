package com.algorithm.week08;

public class LeetCode_300_0100 {

  //DP
  public int lengthOfLIS(int[] nums) {
    if (nums.length <= 0) {
      return 0;
    }
    //定义状态数组
    int[] dp = new int[nums.length];
    dp[0] = 1;
    int maxres = 1;
    for (int i = 1; i < dp.length; i++) {
      int max = 0;
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          max = Math.max(max, dp[j]);
        }
      }
      dp[i] = max + 1;
      maxres = Math.max(maxres, dp[i]);
    }
    return maxres;
  }

  public static void main(String[] args) {
    LeetCode_300_0100 test = new LeetCode_300_0100();
    int val = test.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
    System.out.println(val);
  }
}

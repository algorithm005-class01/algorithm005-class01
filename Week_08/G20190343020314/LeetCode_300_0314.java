package week08;

import java.util.Arrays;

/**
 * Description: 最长上升子序列.
 *
 * @author Wengy
 * @since JDK 1.8
 * @since 1.0.0
 */
public class LeetCode_300_0314 {
  class Solution {
    public int lengthOfLIS(int[] nums) {
      if(nums.length<=1) {
        return nums.length;
      }
      int[] dp = new int[nums.length];
      int max = 0;
      dp[0]=1;
      int maxLength = 1;
      if(nums[1]>nums[0]) {
        dp[1]=2;
        maxLength = 2;
      } else {
        dp[1]=1;
        maxLength = 1;
      }
      
      for(int i=2; i<nums.length; i++) {
        int maxVal = 0;
        for(int j=0; j<i; j++){
          if(nums[j]<nums[i]) {
            maxVal = Math.max(dp[j],maxVal);
          }
        }
        dp[i] = maxVal + 1;
        maxLength = Math.max(dp[i],maxLength);
      }
      
      System.out.println(Arrays.toString(dp));
      return maxLength;
    }
  }
}

package main.leetcode_solutions.dynamic_programming;

/**
 * @author wenzhuang
 * @date 2020/2/16 10:12 PM
 */
public class T300_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        int maxSofar = 0;
        for (int i = 0; i < nums.length; i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                }
            }
            maxSofar = Math.max(maxSofar, dp[i]);
        }
        return maxSofar;
    }
}

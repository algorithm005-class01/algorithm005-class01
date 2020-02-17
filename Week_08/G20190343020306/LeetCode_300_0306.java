class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 2) { return nums.length; }
        int dp[] = new int[nums.length];
        dp[0] = 1;
        int maxAnswer = 0;
        for (int i = 1; i < nums.length; i++) {
            int maxValue = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxValue = Math.max(dp[j], maxValue); //找出之前的dp[j]最大值, 且满足nums[i] > nums[j]
                }
                dp[i] = maxValue + 1;
            }
            maxAnswer = Math.max(maxAnswer, dp[i]);
        }
        return maxAnswer;
    }
}
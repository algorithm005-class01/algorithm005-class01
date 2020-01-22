class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        vector<int> dp(nums);
        int maxsum = dp[0];
        for (int i = 1; i < dp.size(); i++)
        {
            dp[i] = max(dp[i-1] + nums[i], nums[i]);
            maxsum = max(dp[i], maxsum);
        }
        return maxsum;
    }
};
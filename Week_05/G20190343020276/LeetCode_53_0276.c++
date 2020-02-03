class Solution {
public:
    int maxSubArray(vector<int>& nums)
    {
        // 找重复子问题
        // 定义状态 :dp[i]表示为以nums[i]结尾的连续子数组的最大和
        // 状态转移方程如下：
        // 如果dp[i]大于0:dp[i] = dp[i-1] + nums[i]
        // 如果dp[i]小于0:dp[i] = nums[i]
        // 定义初始状态 dp[0] = nums[0];

        if(nums.size() == 0)
            return 0;
        
        vector<int> dp(nums);
        dp[0] = nums[0];
        for(int i=1;i<nums.size();i++)
        {
            dp[i] = max(nums[i],dp[i-1] + nums[i]);
        }

        return *std::max_element(dp.begin(),dp.end());
    }
};
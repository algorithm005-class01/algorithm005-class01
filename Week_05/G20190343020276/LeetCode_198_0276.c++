class Solution {
public:
    int rob(vector<int>& nums)
    {
        // 方法一
        // 找重复子问题
        // 定义状态 dp[i]表示 偷盗至第i个房子时的最大总金额
        // 第i个房子有两种选择，偷或者不偷
        // 状态转移方程 dp[i] = max(dp[i-1],dp[i-2] + nums[i])

        // 方法二
        // 每个房间都有两种状态，1:偷 0:不偷
        // 如果第i个房子偷 则i-1个房子必定不偷，状态转移方程为 dp[i][1] = dp[i-1][0] + nums[i];
        // 如果第i个房子不偷，那么i-1个房子可以偷，也可以不偷 dp[i][0] = max(dp[i-1][1],dp[i-1][0]);

        if(nums.size() == 0)
            return 0;
        int num = nums.size();
        vector<vector<int>> dp(nums.size(),vector<int>(2));
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for(int i=1;i<nums.size();++i)
        {
            dp[i][0] = max(dp[i-1][1],dp[i-1][0]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return max(dp[num-1][0],dp[num-1][1]);
    }
};
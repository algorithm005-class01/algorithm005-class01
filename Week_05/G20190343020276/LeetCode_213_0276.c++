class Solution {
public:
    int rob(vector<int>& nums) {
        // 找重复子问题
        // 定义状态 dp[i]表示偷至第i个房子的最大总金额
        // 状态转移方程
        // 如果第一个偷 nums.size()肯定不能偷
        // 如果第一个不偷 nums.size()可以偷，可以不偷
        // 把环状转化成单排排列
        // 分别求出去掉第一个房子可以偷的最大总金额dp1[i]和去掉最后一个房子可以偷到的最大总金额dp2[i]

        if(nums.size() == 0)
            return 0;
        if(nums.size() == 1)
            return nums[0];
        if(nums.size() == 2)
            return max(nums[0],nums[1]);
        int size = nums.size();
        vector<int> dp1(size),dp2(size);

        dp1[0] = 0;
        dp1[1] = nums[1];
        
        dp2[0] = nums[0];
        dp2[1] = max(nums[0],nums[1]);

        // 去掉第一个和最后一个
        for(int i=2;i<size;++i)
        {
            dp1[i] = max(dp1[i-1],dp1[i-2] + nums[i]);
            dp2[i] = max(dp2[i-1],dp2[i-2] + nums[i]);
        }
        return max(dp1[size-1],dp2[size-2]);
    }
};
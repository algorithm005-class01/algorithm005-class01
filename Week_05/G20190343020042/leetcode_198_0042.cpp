class Solution {
public:
	
    int rob(vector<int>& nums) {
     int sum0 = 0, sum1 = 0;     
        for(int i = 0; i < nums.size(); ++i)
        {
            if(i % 2 == 0)
            {
                sum0 += nums[i];
                sum0 = max(sum0, sum1);
            }
            else
            {
                sum1 += nums[i];
                sum1 = max(sum0, sum1);
            }
        }
        return max(sum0, sum1);
    }
};
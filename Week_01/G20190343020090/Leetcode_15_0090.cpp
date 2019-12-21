class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int> > res;
        int n = nums.size();
        if (n == 0)
            return res;
        sort(nums.begin(), nums.end());
        
        for (int i = 0; i < n - 2; i++)
        {
            if (nums[i] > 0) 
                break;
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int j = i + 1;
            int k = nums.size() - 1;
            while (j < k)
            {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0)
                {
                    j++;
                    //while(j < k && nums[j] == nums[j-1])
                    //    j++; 
                }
                if (sum > 0)
                {
                    k--;
                    //while(j < k && nums[k] == nums[k+1])
                    //    k--;
                }
                if (sum == 0)
                {
                    res.push_back({nums[i], nums[j], nums[k]});
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j-1])
                        j++;
                    while(j < k && nums[k] == nums[k+1])
                        k--;
                }
            }
        }
        return res;
    }
};
class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.empty())
            return 0;
        int size = nums.size();
        if(size == 1)
            return nums[0];
        
        int prev = 0;
        int curr = 0;
        for(int i = 0; i < size; i++)
        {
            int tmp = curr;
            curr = max(curr,  prev + nums[i]);
            prev = tmp; 
        }
        return curr;
    }
};
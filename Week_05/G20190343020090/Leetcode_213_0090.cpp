class Solution {
public:
    int rob(vector<int>& nums) {
        int size = nums.size();
        if (size == 1)
            return nums[0];
        
        return max(robber(nums, 0, size-2), robber(nums, 1, size-1));
    }

    int robber(vector<int>& nums, int l, int r)
    {
        int pre = 0;
        int cur = 0;

        for (int i = l; i <= r; i++)
        {
            int temp = max(pre + nums[i], cur);
            pre = cur;
            cur = temp;
        }
        return cur;
    }
};
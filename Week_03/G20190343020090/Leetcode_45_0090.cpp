class Solution {
public:
    int jump(vector<int>& nums) {
        int res = 0;
        int end = 0;
        int maxpos = 0;
        for (int i = 0; i < nums.size() - 1; i++)
        {
            maxpos = max(nums[i] + i, maxpos);
            if (i == end)
            {
                end = maxpos;
                res++;
            }
        }

        return res;
    }
};
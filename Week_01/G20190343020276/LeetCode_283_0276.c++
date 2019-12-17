class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        // int j = 0;
        // for(int i=0;i<nums.size();i++)
        // {
        //     if(nums[i] !=0)
        //     {
        //         nums[j] = nums[i];
        //         if(i != j)
        //         {
        //             nums[i] = 0;
        //         }
        //         j++;
        //     }
        // }
        int lastNoneZeroPos = 0;
        for(int cur=0;cur<nums.size();cur++)
        {
            if(nums[cur] != 0)
            {
                swap(nums[lastNoneZeroPos++],nums[cur]);
            }
        }
    }
};
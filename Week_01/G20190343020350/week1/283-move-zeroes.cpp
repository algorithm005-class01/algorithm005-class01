class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int len = nums.size();
        int j = 0;
        for (int i = 0; i < len; i++)
        {
            if (nums[i] != 0)
            {
                nums[j] = nums[i];
                if (i != j)
                    nums[i] = 0;
                j++;
            }
            
        }
    }
};

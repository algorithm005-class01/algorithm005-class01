class Solution {
public:
    int removeDuplicates(vector<int>& nums) 
    {
        if(nums.size() < 2)
            return nums.size();
        
        vector<int>::size_type count = 1;
        for(vector<int>::size_type i=1; i<nums.size();i++)
        {
            if(nums[i-1] != nums[i])
            {
                nums[count++] = nums[i];
            }
        }
        return count;
    }
};
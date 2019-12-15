class Solution {
public:
    void rotate(vector<int>& nums, int k) 
    {
        //方法1:暴力解法，旋转k次
        // for(vector<int>::size_type i=0;i<k;i++)
        // {
        //     vector<int>::size_type last=nums[nums.size() - 1];
        //     vector<int>::size_type temp = 0;
        //     for(vector<int>::size_type j=0;j<nums.size();j++)
        //     {
        //         temp = nums[j];
        //         nums[j] = last;
        //         last = temp;
        //     }
        // }

        //方法2:三次旋转法
        vector<int>::size_type temp = 0;
        vector<int>::size_type ratateLen = k%nums.size();
        vector<int>::size_type i = 0;
        vector<int>::size_type j = 0;

        // if(ratateLen == 0)
        // {
        //     return;
        // }
        for(i=0,j=nums.size() - ratateLen - 1;i<j;i++,j--)
        {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        for(i=nums.size() - ratateLen,j=nums.size()-1;i<j;i++,j--)
        {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        for(i=0,j=nums.size()-1;i<j;i++,j--)
        {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        
    }
};
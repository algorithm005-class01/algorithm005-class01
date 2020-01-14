class Solution {
public:
    int findMin(vector<int>& nums) {
        // int min = INT_MAX;

        // for(int num:nums)
        // {
        //     if(num<min)
        //         min=num;
        // }
        // return min;

        int left = 0;
        int right = nums.size() - 1;

        if(nums[right] >= nums[left])
            return nums[0];

        while(left<=right)
        {
            int mid = left + (right - left)/2;

            if(nums[mid] > nums[mid+1])
                return nums[mid+1];
            
            if(nums[mid-1] > nums[mid])
                return nums[mid];
            
            if(nums[mid] > nums[0])
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }

        return -1;
    }
};
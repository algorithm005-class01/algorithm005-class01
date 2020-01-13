class Solution {
public:
    int search(vector<int>& nums, int target) {
        int left = 0;
        int right = nums.size() - 1;
        
        while(left<right)
        {
            int mid = left + (right - left)/2;
            //不包含旋转数组时
            if(nums[0] <= nums[mid] && (target < nums[0] || target >nums[mid]))
            {
                left = mid + 1;
            }
            //包含旋转数组
            else if(nums[0] > nums[mid] && (target < nums[0] && target >nums[mid]))
            {
                left = mid + 1;
            }
            else
            {
                right = mid;
            }
        }
        return left==right && target==nums[left]? left : -1;
    }
};

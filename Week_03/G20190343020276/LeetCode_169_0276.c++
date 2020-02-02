class Solution {

private:
    int majority(vector<int>& nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = left + (right - left) / 2;

        //分治法：计算左右两边的众数
        int leftMa  = majority(nums, left, mid);//计算左边的众数
        int rightMa = majority(nums, mid + 1, right);
        if (leftMa == rightMa) 
        {
            return leftMa;
        }
        return count(nums.begin() + left, nums.begin() + right + 1, leftMa) > 
               count(nums.begin() + left, nums.begin() + right + 1, rightMa) ? leftMa : rightMa;
    }
public:
    int majorityElement(vector<int>& nums) {
        return majority(nums, 0, nums.size() - 1);
    }

};

class Solution {
public:
    void reverseArray(vector<int>& nums, int start, int end) {
        int tmp = 0;
        while(start < end) {
            tmp = nums[end];
            nums[end] = nums[start];
            nums[start] = tmp;
            end--;
            start++;
        }
    }
    void rotate(vector<int>& nums, int k) {
        k %= nums.size();
        reverseArray(nums, 0, nums.size()-1);
        reverseArray(nums, 0, k-1);
        reverseArray(nums, k, nums.size()-1);
    }
};

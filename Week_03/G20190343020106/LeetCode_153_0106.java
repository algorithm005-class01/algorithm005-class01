package week03;

class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return min(nums[0], nums[1]);

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[l] <= nums[mid] && nums[mid] <= nums[r])
                return nums[l];

            if (nums[l] > nums[mid]) {
                l = l + 1;
                r = mid;
            } else if (nums[r] < nums[mid]) {
                l = mid + 1;
            } else {
                assert (false);
            }
        }
        return nums[l];
    }

    private int min(int a, int b) {
        return a < b ? a : b;
    }
}

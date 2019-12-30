package week03;

class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target)
                return mid;

            if (target < nums[mid]) {
                if (nums[l] <= nums[r] || nums[mid] < nums[l])
                    r = mid - 1;
                else if (target >= nums[l])
                    r = mid - 1;
                else
                    l = mid + 1;
            } else {
                if (nums[l] <= nums[r] || nums[mid] > nums[r])
                    l = mid + 1;
                else if (target >= nums[l])
                    r = mid - 1;
                else
                    l = mid + 1;
            }
        }

        return -1;
    }
}

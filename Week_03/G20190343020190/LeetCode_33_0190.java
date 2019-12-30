public class LeetCode_33_0190 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = (right + left) >> 1;
        while (left <= right) {
            if (nums[mid] == target) return mid;
            if (nums[left] <= nums[mid]) {
                //left is order
                if (nums[left] <= target && target < nums[mid]) {
                    //target in left
                    right = mid - 1;
                } else {
                    //target in right
                    left = mid + 1;
                }
            } else {
                //right is order
                if (nums[mid] < target && target <= nums[right]) {
                    //target in right
                    left = mid + 1;
                } else {
                    //target in left
                    right = mid - 1;
                }
            }
            mid = (right + left) >> 1;
        }
        return -1;
    }
}

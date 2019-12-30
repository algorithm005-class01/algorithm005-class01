public class LeetCode_153_0190 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < nums[right]) right = mid;//证明在左边
            else left = mid + 1;//证明在右边
        }
        return nums[left];
    }
}

public class LeetCode_169_0190 {
    public int majorityElement(int[] nums) {
        return majorityElementHelp(nums, 0, nums.length - 1);
    }

    private int majorityElementHelp(int[] nums, int lo, int hi) {
        if (lo == hi) return nums[lo];
        int mid = ((hi - lo) >> 1) + lo;
        int left = majorityElementHelp(nums, lo, mid);
        int right = majorityElementHelp(nums, mid + 1, hi);
        if (left == right) return left;
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);
        return leftCount > rightCount ? left : right;
    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) count++;
        }
        return count;
    }
}

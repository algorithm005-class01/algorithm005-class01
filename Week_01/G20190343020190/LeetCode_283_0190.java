public class LeetCode_283_0190 {
    public void moveZeroes(int[] nums) {
        int lastNonZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[lastNonZero];
                nums[lastNonZero++] = nums[i];
                nums[i] = temp;
            }
        }
    }
}

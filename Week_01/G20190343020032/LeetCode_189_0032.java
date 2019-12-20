class Solution {
    public void rotate(int[] nums, int k) {
        if (k <= 0) {
            return;
        }
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int begin, int end) {
        for (; begin < end; begin++, end--) {
            int tmp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = tmp;
        }
    }
}
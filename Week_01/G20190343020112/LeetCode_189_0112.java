class Solution {
    // 解法一：暴力法，遍历数组，每次移动1个位置，移动k次。不考虑
    // 解法二：空间换时间，新建一个数组，但要求空间O(1)。不考虑
    // 解法三：反转
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k == 0) {
            return;
        }

        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    private void reverse(int[] nums, int start, int end) {
        int tmp = 0;
        while (start < end) {
            tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }
    }
}
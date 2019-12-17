public class LeetCode_189_0192 {

    // https://leetcode-cn.com/problems/rotate-array/
    // 之前的解题思路：https://leetcode-cn.com/problems/rotate-array/solution/wo-cai-3ci-fan-zhuan-shi-zhe-yang-xiang-dao-de-by-/
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        if (length < 2) {
            return;
        }

        reverse(nums, 0, length - 1);
        k = k % length;
        reverse(nums, 0, k - 1);
        reverse(nums, k, length - 1);
    }

    /**
     * 反转数组
     * @param nums
     * @param start 数组开始下标
     * @param end 数组结束下标
     */
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

}

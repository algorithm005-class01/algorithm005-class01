/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    public void reverse(int[] nums,int start,int end){
        while(start<end){
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }

    }

    public void rotate(int[] nums, int k) {
        /**
         * 解法2:反转 首先将整个数组反转,然后找到nums[0]对应的位置即nums[k%nums.length],
         * 以此为点,将两段数组分别反转,这样所有数组都回到正常的顺序,且位置正确
         */
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);

        /**
         * 解法1: 轮询一次数组,将每个数字移动到
         * 相应的位置,并用另一个数组存储,之后再
         * 赋值回来,时间复杂度为O(2n)
         */
        /*
        int length = nums.length;
        int[] nums2 = new int[length];
        for (int i = 0; i < length; i++) {
            int t = (i+k)%length;
            nums2[t] = nums[i];
        }
        for (int j = 0; j < length; j++) {
            nums[j] = nums2[j];
        }
        */
    }
}
// @lc code=end


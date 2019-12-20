package week_01.commit;

import java.util.List;

// 旋转数组
// https://leetcode-cn.com/problems/rotate-array/
public class Solution_189 {

    // 反转思路
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k != 0) {
            reverse(nums, 0, nums.length -1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length -1);
        }
    }

    public void reverse(int[] nums, int start, int end) {
        int temp;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

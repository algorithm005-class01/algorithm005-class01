package week_01.commit;

// 加一
// https://leetcode-cn.com/problems/plus-one/
public class Solution_66 {
    private int[] plusOne(int[] nums) {
        if (null == nums || nums.length <= 0) {
            return null;
        }
        int len = nums.length;
        for (int i = len - 1; i >= 0; i--) {
            nums[i]++;
            nums[i] %= 10;
            if (nums[i] != 0) {
                return nums;
            }
        }
        nums = new int[len + 1];
        nums[0] = 1;
        return nums;
    }
}

package week_01.commit;

// 移动零
// https://leetcode-cn.com/problems/move-zeroes/
public class Solution_283 {

    private static void moveZeroes(int[] nums) {
        if(nums == null || nums.length <= 0){
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[index++] = nums[i];
            }
        }
        while (index < nums.length){
            nums[index++] = 0;
        }
    }

    private static void moveZeroes2(int[] nums) {
        if(nums == null || nums.length <= 0){
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index++;
            }
        }
    }
}

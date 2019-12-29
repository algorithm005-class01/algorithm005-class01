package week01;

public class Leetcode_283_0230 {

    // 输入: [0,1,0,3,12]
    // 输出: [1,3,12,0,0]
    public void moveZer6oes(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}

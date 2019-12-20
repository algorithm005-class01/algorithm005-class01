package main.leetcode_solutions.array;

/**
 * @author wenzhuang
 * @date 2019/12/15
 */
public class T283_MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        int i = -1, j = 0;
        while (j < nums.length){
            if (nums[j] != 0){
                i++;
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
            }
            j++;
        }
    }
}

package main.leetcode_solutions.array;

/**
 * @author wenzhuang
 * @date 2019-12-15
 */
public class T189_RotateArray {

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0){
            return;
        }
        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j){
        while (i < j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }

}

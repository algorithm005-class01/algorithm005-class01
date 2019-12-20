package week01;

public class Leetcode_189_0230 {

//    暴力法
//    public void rotate(int[] nums, int k) {
//        if (nums == null || nums.length == 0) return;
//        if (k > 0) {
//            int temp, prev;
//            for (int i = 0; i < k; i++) {
//                prev = nums[nums.length - 1];
//                for (int j = 0; j < nums.length; j++) {
//                    temp = nums[j];
//                    nums[j] = prev;
//                    prev = temp;
//                }
//            }
//        }
//    }

    // 原始数组                  : 1 2 3 4 5 6 7
    // 反转所有数字后             : 7 6 5 4 3 2 1
    // 反转前 k 个数字后          : 5 6 7 4 3 2 1
    // 反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverseArr(nums, 0, nums.length - 1);
        reverseArr(nums, 0, k - 1);
        reverseArr(nums, k, nums.length - 1);
    }

    public void reverseArr(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

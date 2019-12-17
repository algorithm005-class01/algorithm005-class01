/**
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
*/
import java.util.Arrays;

class Solution {
    public static void main (String args []) {
        int[] numsArray = {1,2,3,4,5,6,7};
        int k = 3;
        System.out.print(Arrays.toString(numsArray));
        int[] rotateArray = rotate(numsArray,k); 
        System.out.print(Arrays.toString(rotateArray));
    }  

    public static int[] rotate(int[] nums, int k) {
        int temp,previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
        return nums;
    }
}
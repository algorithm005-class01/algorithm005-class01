/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
*/
import java.util.Arrays;

class Solution {
    public static void main (String args []) {
        int[] numsArray = {0,1,0,3,12};
        System.out.print(Arrays.toString(numsArray));

        moveZeroes(numsArray);
        System.out.print(Arrays.toString(numsArray));
    }  

    public static void moveZeroes(int[] nums) {
        int index = 0;
        for(int num:nums){
            if(num != 0){
                nums[index++]=num;
            }
        }
        while(index < nums.length){
            nums[index++] = 0;
        }
    }
}
package main.leetcode_solutions.array;

/**
 * @author wenzhuang
 * @date 2019-12-15
 */
public class T26_RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int i = 0, j = 0;
        while (j < nums.length){
            if (nums[j] != nums[i]){
                nums[++i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }
}

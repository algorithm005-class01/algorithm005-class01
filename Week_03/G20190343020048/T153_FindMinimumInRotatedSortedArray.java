package main.leetcode_solutions.search;

/**
 * @author wenzhuang
 * @date 2019/12/29 9:23 PM
 */
public class T153_FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int low = 0, high = nums.length - 1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if ((mid == 0 && nums[mid] < nums[nums.length - 1]) || (mid > 0 && nums[mid] < nums[mid - 1])){
                return nums[mid];
            } else if (nums[mid] > nums[nums.length - 1]){
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        return nums[0];
    }
}

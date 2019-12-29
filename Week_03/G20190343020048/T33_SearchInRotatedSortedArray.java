package main.leetcode_solutions.search;

public class T33_SearchInRotatedSortedArray {

     public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        int low = 0, high = nums.length - 1;
        while (low <= high){
            int mid = ((high - low) >> 1) + low;
            if (nums[mid] == target){
                return mid;
            } else {
                if (nums[mid] > nums[nums.length - 1]){
                    if (target < nums[mid] && target >= nums[0]){
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else {
                    if (target > nums[mid] && target <= nums[nums.length - 1]){
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
        }
        return -1;
    }
}

package week_01.commit;

import java.util.*;

// 删除排序数组中的重复项
// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
public class Solution_26 {
    public int removeDuplicates3(int[] nums) {
        if (null == nums || nums.length <= 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[j - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}

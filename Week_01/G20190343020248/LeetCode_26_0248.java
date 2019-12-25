//删除排序数组中的重复项

/**
 * 1.快慢指针法解题
 * 2.i,j最多分别遍历n次，时间复杂度O(n)，空间复杂度O(1)
 */
public class LeetCode_26_0248 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}

package G20190343020064;


/**
 * <p>
 * 删除排序数组中的重复项
 * </p>
 *
 * @author mingke  2019-12-14 4:34 下午
 */
public class LeetCode_26_0064 {

    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

}

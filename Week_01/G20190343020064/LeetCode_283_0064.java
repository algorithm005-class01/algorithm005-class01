package G20190343020064;

/**
 * <p>
 * 零移动
 * </p>
 *
 * @author mingke  2019-12-10 8:34 下午
 */
public class LeetCode_283_0064 {


    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            }
            if (count != 0 && nums[i] != 0) {
                nums[i - count] = nums[i];
            }
        }
        for (int i = nums.length - count; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}

package G20190343020064;


/**
 * <p>
 * 旋转数组
 * </p>
 *
 * @author mingke  2019-12-14 5:40 下午
 */
public class LeetCode_189_0064 {


    public void rotate(int[] nums, int k) {
        int[] copyNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int target = (i + k) % nums.length;
            copyNums[target] = nums[i];
        }
        System.arraycopy(copyNums, 0, nums, 0, nums.length);
    }

}

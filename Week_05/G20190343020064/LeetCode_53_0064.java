package G20190343020064;

/**
 * <p>
 * 最大子序和
 * </p>
 *
 * @author mingke.yan@hand-china.com 2020-01-11 3:09 下午
 */
public class LeetCode_53_0064 {

    /**
     * sum 当前下标之前 数字和，如果sum < 0 则重置为0
     * max 为记录之前出现过最大得数字
     * max = max(sum,max);  sum 为加了当前下标后得结果，max是之前出现最大得和
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        Integer max = null;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            max = max == null ? nums[i] : Math.max(sum, max);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

}

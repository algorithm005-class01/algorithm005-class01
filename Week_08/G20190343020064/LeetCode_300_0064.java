package G20190343020064;

import java.util.Arrays;

/**
 * <p>
 * 最长上升子序列
 * </p>
 *
 * @author mingke.yan@hand-china.com 2020-02-16 3:33 下午
 */
public class LeetCode_300_0064 {


    /**
     * dp[i] = max(dp[i],dp[j] + 1)  ; j in [0,i)
     * O(n^2)
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int result = 0;
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    //===============================================================================
                    //  如果 dp[i] > dp[j] 则舍弃 dp[j]
                    //  如果 dp[i] < dp[j] + 1 则 dp[i] = dp[j] + 1
                    //===============================================================================
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            if (dp[i] > result) {
                result = dp[i];
            }
        }
        return result;
    }

}

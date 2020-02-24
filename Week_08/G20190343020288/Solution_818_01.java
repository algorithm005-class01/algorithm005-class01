package week_08.commit;

import java.util.Arrays;

// 818. 赛车
// https://leetcode-cn.com/problems/race-car/
public class Solution_818_01 {

    public int racecar(int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, 1, dp.length, -1);
        return racecar(target, dp);
    }

    private int racecar(int i, int[] dp) {
        if (dp[i] >= 0) {
            return dp[i];
        }

        dp[i] = Integer.MAX_VALUE;

        int m = 1, j = 1;

        for (; j < i; j = (1 << ++m) - 1) {
            for (int q = 0, p = 0; p < j; p = (1 << ++q) - 1) {
                dp[i] = Math.min(dp[i], m + 1 + q + 1 + racecar(i - (j - p), dp));
            }
        }

        dp[i] = Math.min(dp[i], m + (i == j ? 0 : 1 + racecar(j - i, dp)));

        return dp[i];
    }

    public int racecar2(int target) {
        int[] dp = new int[target + 1];

        for (int i = 1; i <= target; i++) {
            dp[i] = Integer.MAX_VALUE;

            int m = 1, j = 1;

            for (; j < i; j = (1 << ++m) - 1) {
                for (int q = 0, p = 0; p < j; p = (1 << ++q) - 1) {
                    dp[i] = Math.min(dp[i], m + 1 + q + 1 + dp[i - (j - p)]);
                }
            }
            dp[i] = Math.min(dp[i], m + (i == j ? 0 : 1 + dp[j - i]));
        }

        return dp[target];
    }
}

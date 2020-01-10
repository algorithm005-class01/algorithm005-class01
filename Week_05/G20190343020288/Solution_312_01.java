package week_05.commit;

// 312. 戳气球
// https://leetcode-cn.com/problems/burst-balloons/
public class Solution_312_01 {

    public int maxCoins2(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int[][] dp = new int[n + 1][n + 1];
        return helper(dp, 0, n - 1, nums);
    }

    private int helper(int[][] dp, int i, int j, int[] nums) {
        if (i > j) return 0;
        // if (i == j) return getNums(i-1, nums) * nums[i] * getNums(j+1, nums);

        if (dp[i][j] > 0) return dp[i][j];

        int res = 0;
        for (int k = i; k <= j; k++) {
            int val = helper(dp, i, k - 1, nums)
                    + getNums(i - 1, nums) * nums[k] * getNums(j + 1, nums)
                    + helper(dp, k + 1, j, nums);
            res = Math.max(res, val);
        }

        dp[i][j] = res;
        return res;
    }

    private int getNums(int i, int[] nums) {
        if (i == -1 || i == nums.length) {
            return 1;
        }

        return nums[i];
    }
}

package com.zyh.test.leetcode;

public class LeetCode_64_0004 {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[] dp = new int[grid.length];
        dp[0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i] = dp[i - 1] + grid[i][0];
        }
        for (int j = 1; j < grid[0].length; j++) {
            dp[0] += grid[0][j];
            for (int i = 1; i < grid.length; i++) {
                dp[i] = Math.min(dp[i - 1], dp[i]) + grid[i][j];
            }
        }
        return dp[grid.length - 1];
    }
}

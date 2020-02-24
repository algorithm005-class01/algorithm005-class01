package com.algorithm.week05;

public class LeetCode_64_0100 {

  public int minPathSum(int[][] grid) {
    //DP ：
    //subProbrem:  dp[m][n] = dp[m - 1][n] 或者 dp[m][n] = dp[m][n - 1] 可以到达
    //array： dp[m + 1][n + 1]
    //Dp express :min(dp[m - 1][n], dp[m][n - 1]) + 1
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int hig = grid.length, len = grid[0].length;
    int[][] dp = new int[hig][len];

    //技术处理
    dp[0][0] = grid[0][0];
    for (int j = 1; j < len; j++) {
      dp[0][j] = dp[0][j - 1] + grid[0][j];
    }
    for (int k = 1; k < hig; k++) {
      dp[k][0] = dp[k - 1][0] + grid[k][0];
    }

    for (int m = 1; m < hig; m++) {
      for (int n = 1; n < len; n++) {
        dp[m][n] = Math.min(dp[m - 1][n], dp[m][n - 1]) + grid[m][n];
      }
    }
    return dp[hig - 1][len - 1];
  }
}

package main.leetcode_solutions.dynamic_programming;

public class T64_MinimumPathSum {
    /**
     * dp[i][j] = grid[i][j] + min{dp[i-1][j], dp[i][j-1]};
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++){
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++){
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 空间优化的解法
     * @param grid
     * @return
     */
    public int minPathSum2(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int j = 1; j < n; j++){
            dp[j] = dp[j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++){
            for (int j = 0; j < n; j++){
                dp[j] = grid[i][j] + (j == 0 ? dp[j] : Math.min(dp[j], dp[j - 1]));
            }
        }
        return dp[n - 1];
    }
}

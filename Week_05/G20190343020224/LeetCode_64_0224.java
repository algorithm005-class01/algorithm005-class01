// DP方程
// f(i, j) = min(f(i - 1, j), f(i, j - 1)) + a(i, j)

class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[] dp = new int[column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 && j == 0) {
                    dp[0] = grid[0][0];
                } else if (i == 0) {
                    dp[j] = dp[j - 1] + grid[0][j];
                } else if (j == 0) {
                    dp[j] += grid[i][0];
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
                }
            }
        }
        return dp[column - 1];

    }
}
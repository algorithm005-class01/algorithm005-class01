class Solution {
    /*
    1. Solution(i, j) = min(sub(i + 1, j), sub(i, j+1)) + v[j]
    2. 定义状态数组f[i, j]
    3. f[i][j] = min(f[i+1][j], f[i][j+1]) + a[i][j]
    4. return f[0][0]
    */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        //初始化最边上行和列
        dp[m-1][n-1] = grid[m-1][n-1];
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n-1] = grid[i][n-1] + dp[i+1][n-1];
        }
        for (int j = n - 2; j >= 0; j--) {
            dp[m-1][j] = grid[m-1][j] + dp[m-1][j+1];
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i+1][j], dp[i][j+1]) + grid[i][j];
            }
        }
        return dp[0][0];
    }
}
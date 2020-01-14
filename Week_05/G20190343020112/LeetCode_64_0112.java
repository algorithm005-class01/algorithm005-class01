class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null) return 0;
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int i = 1; i < n; i++) dp[i] = dp[i - 1] + grid[0][i];
        for (int i = 1; i < m; i++) {
            dp[0] += grid[i][0];
            for (int j = 1;j < n; j++) {
                dp[j] = grid[i][j] + Math.min(dp[j - 1], dp[j]);
            }
        }

        return dp[n - 1];
    }
}



// class Solution {
//     public int minPathSum(int[][] grid) {
//         if (grid == null) return 0;
//         int m = grid.length, n = grid[0].length;
//         int[][] res = new int[m][n];
//         res[0][0] = grid[0][0];
//         for (int i = 1; i < m; i++) res[i][0] = grid[i][0] + res[i - 1][0];
//         for (int i = 1; i < n; i++) res[0][i] = grid[0][i] + res[0][i - 1];
//         for (int i = 1; i < m; i++) {
//             for (int j = 1; j < n; j++) {
//                 res[i][j] = Math.min(grid[i][j]+ res[i - 1][j], grid[i][j] + res[i][j - 1]);
//             }
//         }
//         return res[m-1][n-1];
//     }
// }
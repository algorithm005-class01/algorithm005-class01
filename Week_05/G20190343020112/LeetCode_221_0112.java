class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix != null ? matrix.length : 0, n = m > 0 ? matrix[0].length : 0;

        int[][] dp = new int[m + 1][n + 1];

        int side = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    side = Math.max(side, dp[i][j]);
                }
            }
        }

        return side*side;
    }
}
class Solution {
    public int minPathSum(int[][] grid) {
        /**
         * 思路：此题总体思路为要判断 m,n 到终点的最小数字和，则相当于求 m-1,n 和 m,n-1中较小的哪一个，再加上当前的数字
         * 整体思路与最佳路径的题目差不多，需要注意的是边界条件的处理
         */
        if (grid == null) return 0;
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 && j > 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0 && i > 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else if (i != 0 && j != 0){
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[rows - 1][cols - 1];
    }
}
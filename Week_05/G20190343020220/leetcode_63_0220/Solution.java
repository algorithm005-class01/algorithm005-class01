package Week_05.G20190343020220.leetcode_63_0220;

/**
 * @author Darcy
 * @date 2020-01-09 21:27
 */
public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        /*开始的位置是障碍物  没有路走*/
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        // 开始和结束重合的情况, 1条路
        obstacleGrid[0][0] = 1;

        for (int i = 1; i < m; i++) {
            /*当期位置不是障碍物. 并且前一个有一条路走. 自己才能有一条路*/
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }
        for (int i = 1; i < n; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        return obstacleGrid[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[width - 1];
    }
}

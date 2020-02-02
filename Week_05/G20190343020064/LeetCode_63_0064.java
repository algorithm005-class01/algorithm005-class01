package G20190343020064;

/**
 * <p>
 * 不同路径 II
 * </p>
 *
 * @author mingke.yan@hand-china.com 2020-01-07 10:40 下午
 */
public class LeetCode_63_0064 {

    /**
     * 用62的思想用 一维数组解决
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }
        int[] map = new int[obstacleGrid[0].length];
        map[obstacleGrid[0].length - 1] = 1;
        for (int i = obstacleGrid.length - 1; i >= 0; i--) {
            for (int j = map.length - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    map[j] = 0;
                } else {
                    // 当位置在最右边缘时 防止越界 次数等于下面的次数
                    if (j == map.length - 1) {
                        map[j] = map[j];
                    } else {
                        map[j] = map[j] + map[j + 1];
                    }
                }
            }
        }
        return map[0];
    }

    /**
     * 原地算法利用 原数组存放数据
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        obstacleGrid[n - 1][m - 1] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) {
                    continue;
                }
                obstacleGrid[i][j] = obstacleGrid[i][j] == 0 ? ((i + 1 == n ? 0 : obstacleGrid[i + 1][j]) + (j + 1 == m ? 0 : obstacleGrid[i][j + 1])) : 0;
            }
        }
        return obstacleGrid[0][0];
    }


}

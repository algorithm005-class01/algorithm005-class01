package G20190343020064;

/**
 * <p>
 * 最小路径和
 * </p>
 *
 * @author mingke.yan@hand-china.com 2020-01-10 9:39 上午
 */
public class LeetCode_64_0064 {

    /**
     * 自顶向下
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j != 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if (j == 0 && i != 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else if (i != 0 && j != 0) {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

}

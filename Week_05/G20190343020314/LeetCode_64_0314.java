package week05;

/**
 * Description: 最小路径和.
 *
 * @author Wengy
 * @since JDK 1.8
 * @since 1.0.0
 */
public class LeetCode_64_0314 {
  public int minPathSum(int[][] grid) {
    for(int i=0; i<grid.length; i++) {
      for(int j=0; j<grid[0].length; j++) {
        if(i==0 && j>0) {
          grid[i][j] = grid[i][j] + grid[i][j-1];
          continue;
        }
        if(j==0 && i>0) {
          grid[i][j] = grid[i][j] + grid[i-1][j];
          continue;
        }
        if(i>0 && j>0) {
          grid[i][j] = Math.min(grid[i][j-1],grid[i-1][j]) + grid[i][j];
          continue;
        }
      }
    }
    return grid[grid.length-1][grid[0].length-1];
  }
}

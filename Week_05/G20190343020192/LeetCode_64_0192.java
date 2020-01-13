public class LeetCode_64_0192 {
    // 64. 最小路径和 https://leetcode-cn.com/problems/minimum-path-sum/

    /*
    解法
    因为：每次只能向下或者向右移动一步
    所以只有四种情况：
      1. 最上面一行只能向右移动才能走到：最小距离 = grid[0][j] + grid[0][j - 1]
      2. 最左边一行只能向下移动才能走到：最小距离 = grid[i][0] + grid[i - 1][0]
      3. 最上面以下、最左边以右的区域：最小距离 = min(grid[i - 1][j], grid[i][j - 1])
      4. 左上角第一个元素：最小距离 = 自身数值

    逻辑
      1. 从左到右、从上到下遍历
      2. 到每个格子的最小距离 = 自身数值 + 到该位的较小的一个格子
                          = grid[i][j] = grid[i][j] + min(grid[i - 1][j], grid[i][j - 1])
      3. 遍历结束后，最后一个格子的数值就是最小路径和
     */
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) grid[i][j] = grid[i][j - 1] + grid[i][j];
                else if (j == 0) grid[i][j] = grid[i - 1][j] + grid[i][j];
                else grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}

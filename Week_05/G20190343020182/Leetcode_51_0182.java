package week005;

/*
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
 * */
public class Leetcode_51_0182 {
    // 状态定义
    // dp[i][j] 表示i,j 到右下角的最小路径之和
    // dp 方程
    // i !=0 && j != 0 dp[i][j] = dp[i][j] + Math.min(dp[i][j - 1], dp[i-1][j])
    // i ==0 && j == 0 dp[i][j] = dp[i][j];
    // i ==0 && j != 0 dp[i][j] = dp[i][j] + dp[i][j - 1];
    // i !=0 && j == 0 dp[i][j] = dp[i][j] + dp[i-1][j];
    
	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (i != 0 && j != 0) {
					grid[i][j] = grid[i][j] + Math.min(grid[i][j - 1], grid[i - 1][j]);
				}
				if (i == 0 && j == 0) {
					grid[i][j] = grid[i][j];
				}
				if (i == 0 && j != 0) {
					grid[i][j] = grid[i][j] + grid[i][j - 1];
				}
				if (i != 0 && j == 0) {
					grid[i][j] = grid[i][j] + grid[i - 1][j];
				}
			}
		}

		return grid[grid.length - 1][grid[0].length - 1];
	}
}

"""64. 最小路径和

给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

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

"""


class Solution(object):
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int

        1. dp[i][j] 代表从(0, 0) 走到 (i, j) 路劲上的最小数字和
        2. 要走到(i, j)， 要么从上边(i, j-1)，要么从左边(i-1, j)

            - i==0 时，只能往下走，即 grid[i][j] = grid[i][j-1] + grid[i][j]
            - j==0 时，只能往右走，即 grid[i][j] = grid[i-1][j] + grid[i][j]
            - i，j 都不等于 0 时，从两个来向选一个数字和最小的
        3. 显然初始值为起点(0, 0)
        """
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if i == j == 0:
                    continue
                elif i == 0:
                    grid[i][j] = grid[i][j-1] + grid[i][j]
                elif j == 0:
                    grid[i][j] = grid[i-1][j] + grid[i][j]
                else:
                    grid[i][j] = min(grid[i-1][j], grid[i][j-1]) + grid[i][j]
        return grid[-1][-1]
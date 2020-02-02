from typing import List


class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        if not grid:
            return 0
        m = len(grid)
        n = len(grid[0])
        for i in range(m):
            for j in range(n):
                if i == 0 and j == 0:
                    grid[i][j] = grid[i][j]
                elif i == 0 and j != 0:
                    grid[i][j] = grid[i][j] + grid[i][j - 1]
                elif i != 0 and j == 0:
                    grid[i][j] = grid[i][j] + grid[i - 1][j]
                else:
                    grid[i][j] = grid[i][j] + min(grid[i][j - 1], grid[i - 1][j])
        return grid[m - 1][n - 1]

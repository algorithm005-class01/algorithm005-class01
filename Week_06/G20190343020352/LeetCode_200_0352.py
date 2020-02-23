from typing import List

class Solution:

    def numIslands(self, grid: List[List[str]]) -> int:
        nums = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == "1":
                    nums += self.sink(i, j, grid)
        return nums
        

    def sink(self, i, j, grid):
        if grid[i][j] == "0":
            return 0
        else:
            grid[i][j] = "0"
            for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                x = i + dx
                y = j + dy
                if -1 < x < len(grid) and -1 < y < len(grid[0]) and grid[x][y] == "1":
                    self.sink(x, y, grid)
            return 1
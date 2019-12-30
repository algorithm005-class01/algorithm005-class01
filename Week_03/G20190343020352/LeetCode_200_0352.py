from typing import List


class Solution:

    def numIslands(self, grid: List[List[str]]) -> int:
        def sink(i: int, j: int) -> int:
            if grid[i][j] == "0":
                return 0
            else:
                grid[i][j] = "0"
                for x, y in [(-1, 0), (0, -1), (1, 0), (0, 1)]:
                    new_x = i + x
                    new_y = j + y
                    if 0 <= new_x < len(grid) and 0 <= new_y < len(grid[i]) and grid[new_x][new_y] == '1':
                        sink(new_x, new_y)
                return 1
        islands = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == "1":
                    islands += sink(i, j)
        return islands



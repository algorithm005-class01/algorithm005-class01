# -*- coding: utf-8 -*-
"""https://leetcode-cn.com/problems/number-of-islands/"""
from typing import List


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        res = 0
        m, n = len(grid), len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    res += 1
                    self._infect(grid, i, j)
        return res

    def _infect(self, grid, i, j):
        if not 0 <= i < len(grid) or not 0 <= j < len(grid[i]) or grid[i][j] != '1':
            return None
        grid[i][j] = '0'
        self._infect(grid, i - 1, j)
        self._infect(grid, i + 1, j)
        self._infect(grid, i, j - 1)
        self._infect(grid, i, j + 1)


if __name__ == '__main__':
    grid = [['1', '1', '1', '1', '0'],
            ['1', '1', '0', '1', '0'],
            ['1', '1', '0', '0', '0'],
            ['0', '0', '1', '0', '0']]
    solution = Solution()
    result = solution.numIslands(grid)
    print(result)

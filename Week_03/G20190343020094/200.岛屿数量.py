#
# @lc app=leetcode.cn id=200 lang=python3
#
# [200] 岛屿数量
#
from typing import List
# @lc code=start
class Solution:

    # def numIslands(self, grid: List[List[str]]) -> int:
    #     islands = 0
    #     g = grid
    #     dx = [-1, 1, 0, 0]
    #     dy = [0, 0, -1, 1]

    #     def sink(i, j):
    #         if  g[i][j] == '0': return 0
    #         g[i][j] = '0'
    #         for k in range(len(dx)):
    #             x = i +  dx[k]
    #             y = j +  dy[k]
    #             if (x >= 0 and x < len(g) and y >= 0 and y < len(g[i])):
    #                 if  g[x][y] == '0': continue
    #                 sink(x, y)
    #         return 1


    #     for i in range(len(g)):
    #         for j in range(len(g[i])):
    #             if  g[i][j] == '0': continue
    #             islands += sink(i, j)
    #     return islands

    # 超哥floodfill解法的另一种
    # def numIslands(self, grid):
    #     if not grid:
    #         return 0
            
    #     count = 0
    #     for i in range(len(grid)):
    #         for j in range(len(grid[0])):
    #             if grid[i][j] == '1':
    #                 self.dfs(grid, i, j)
    #                 count += 1
    #     return count

    # def dfs(self, grid, i, j):
    #     if i<0 or j<0 or i>=len(grid) or j>=len(grid[0]) or grid[i][j] != '1':
    #         return
    #     grid[i][j] = '#'
    #     self.dfs(grid, i+1, j)
    #     self.dfs(grid, i-1, j)
    #     self.dfs(grid, i, j+1)
    #     self.dfs(grid, i, j-1)

    # 光头哥牛逼 虽然效率差了点
    def numIslands(self, grid):
        def sink(i, j):
            if 0 <= i < len(grid) and 0 <= j < len(grid[i]) and grid[i][j] == '1':
                grid[i][j] = '0'
                list(map(sink, (i+1, i-1, i, i), (j, j, j+1, j-1)))
                return 1
            return 0
        return sum(sink(i, j) for i in range(len(grid)) for j in range(len(grid[i])))

# @lc code=end

if __name__ == "__main__":
    g = [["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]
    res= Solution().numIslands(g)
    print(res)


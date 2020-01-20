#!/user/bin/python
#-*- coding:utf-8 -*-
import collections

class UnionFind(object):
    def __init__(self, grid):
        m, n = len(grid), len(grid[0])
        self.count = 0
        self.parent = [-1] * (m * n)
        self.rank = [0] * (m * n)
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    self.parent[i * n + j] = i * n + j
                    self.count += 1

    def find(self, i):
        if self.parent[i] != i:
            self.parent[i] = self.find(self.parent[i])
        return self.parent[i]

    def union(self, x, y):
        rootx = self.find(x)
        rooty = self.find(y)
        if rootx != rooty:
            if self.rank[rootx] > self.rank[rooty]:
                self.parent[rooty] = rootx
            elif self.rank[rootx] < self.rank[rooty]:
                self.parent[rootx] = rooty
            else:
                self.parent[rooty] = rootx
                self.rank[rootx] += 1
            self.count -= 1




class Solution:
    def __init__(self):
        self.dx = [-1, 1, 0, 0]
        self.dy = [0, 0, -1, 1]

    #T(n) = O(m*n)
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if not grid or not grid[0]: return 0
        self.max_x = len(grid)
        self.max_y = len(grid[0])
        self.grid = grid
        self.visited = set()
        return sum([self.floodfill_DFS(i, j) for i in range(self.max_x) for j in range(self.max_y)])

    def floodfill_DFS(self, x, y):
        if not self.isValid(x, y):
            return 0
        self.visited.add((x, y))
        for k in range(4):
            self.floodfill_DFS(x + self.dx[k], y + self.dy[k])
        return 1

    def isValid(self, x, y):
        if x < 0 or x >= self.max_x or y < 0 or y >= self.max_y:
            return False
        if self.grid[x][y] == '0' or (x, y) in self.visited:
            return False
        return True

    def numIslands1(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if not grid or not grid[0]: return 0
        self.max_x = len(grid)
        self.max_y = len(grid[0])
        self.grid = grid
        self.visited = set()
        self.count = 0
        [self.floodfill_BFS(i, j) for i in range(self.max_x) for j in range(self.max_y)]

        return self.count

    def floodfill_BFS(self, x, y):
        if not self.isValid(x, y):
            return
        
        self.count += 1

        self.visited.add((x, y))
        queue = collections.deque()
        queue.append((x, y))

        while queue:
            cur_x, cur_y = queue.popleft()
            for i in range(4):
                new_x, new_y = cur_x + self.dx[i], cur_y + self.dy[i]
                if self.isValid(new_x, new_y):
                    queue.append((new_x, new_y))
                    self.visited.add((new_x, new_y))
        


    #T(n) = O(mn)
    def numIslands2(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if not grid or not grid[0]:
            return 0

        uf = UnionFind(grid)
        directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        m, n = len(grid), len(grid[0])

        for i in range(m):
            for j in range(n):
                if grid[i][j] == '0':
                    continue
                for d in directions:
                    nr, nc = i + d[0], j + d[1]
                    if nr >= 0 and nc >= 0 and nr < m and nc < n and grid[nr][nc] == '1':
                        uf.union(i*n+j, nr*n+nc)

        return uf.count


    def findCircleNum_dfs(self, M: List[List[int]]) -> int:
        if not M or not len(M) or not len(M[0]): return 0
        self.m, self.n = len(M), len(M[0])
        self.visited = 
        self.visited = [[False for _ in range(self.n)] for _ in range(self.m)]
        self.count = 0
        for i in range(self.m):
            for j in range(self.n):
                if M[i][j] and not self.visited[i][j]:
                    self.dfs(M, i, j)
                    self.count += 1
        return self.count
    
    def dfs(self, M:List[List[int]], i:int, j:int):
        if i < 0 or i >= self.m or j < 0 or j >= self.n: return
        if not M[i][j] or self.visited[i][j]: return
        self.visited[i][j] = True
        self.dfs(M, i + 1, j)
        self.dfs(M, i - 1, j)
        self.dfs(M, i, j + 1)
        self.dfs(M, i, j - 1)


# Given a 2d grid map of '1's (land) and '0's (water), 
#count the number of islands. 
#An island is surrounded by water 
#and is formed by connecting adjacent lands horizontally or vertically. 
#You may assume all four edges of the grid are all surrounded by water.

import unittest
class SolutionTestCase(unittest.TestCase):
    def testCaseSolution(self): 
        solution = Solution()
        input = [['1', '1', '1', '1', '0'],
                 ['1', '1', '0', '1', '0'],
                 ['1', '1', '0', '0', '0'],
                 ['0', '0', '0', '0', '0']]

        self.assertTrue(solution.numIslands(input) == 1)
        self.assertTrue(solution.numIslands1(input) == 1)
        self.assertTrue(solution.numIslands2(input) == 1)
        input = [['1', '1', '0', '0', '0'],
                 ['1', '1', '0', '0', '0'],
                 ['0', '0', '1', '0', '0'],
                 ['0', '0', '0', '1', '1']]
        self.assertTrue(solution.numIslands(input) == 3)
        self.assertTrue(solution.numIslands1(input) == 3)
        self.assertTrue(solution.numIslands2(input) == 3)

if __name__ == "__main__" : unittest.main()
#!/user/bin/python
#-*- coding:utf-8 -*-


class UnionFind(object):
    def __init__(self, length):
        self.count = length
        self.parent = [i for i in range(length)]

    def find(self, i):
        if self.parent[i] != i:
            self.parent[i] = self.find(self.parent[i])
        return self.parent[i]

    def union(self, x, y):
        rootx = self.find(x)
        rooty = self.find(y)
        if rootx != rooty:
            self.parent[rootx] = rooty
            self.count -= 1


from typing import List
class Solution:
    def findCircleNum_dfs(self, M: List[List[int]]) -> int:
        if not M or not len(M) or not len(M[0]): return 0
        self.count, self.length = 0, len(M)
        self.visited = [False] * self.length
        for i in range(self.length):
            if not self.visited[i]:
                self.dfs(M, i)
                self.count += 1
        return self.count
    
    def dfs(self, M:List[List[int]], i:int):
        for j in range(self.length):
            if M[i][j] and not self.visited[j]: 
                self.visited[j] = True
                self.dfs(M, j)

    def findCircleNum(self, M: List[List[int]]) -> int:
        if not M or not len(M) or not len(M[0]): return 0
        uf = UnionFind(len(M))
        for i in range(len(M)):
            for j in range(len(M[0])):
                if M[i][j]:
                    uf.union(i, j)
        return uf.count




import unittest
class SolutionTest(unittest.TestCase):
    def testSolution(self):
        solution = Solution()
        input = [[1,0,0,1],
                 [0,1,1,0],
                 [0,1,1,1],
                 [1,0,1,1]]
        self.assertTrue(solution.findCircleNum_dfs(input) == 1)
        self.assertTrue(solution.findCircleNum(input) == 1)

if __name__ == "__main__" : unittest.main()

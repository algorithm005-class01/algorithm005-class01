class Solution(object):

    def uniquePaths(self, m: int, n: int) -> int:
        grid = [[1] * n for _ in range(m)]
        for i in range(1, m):
            for j in range(1, n):
                grid[i][j] = grid[i-1][j] + grid[i][j-1]
        return grid[m-1][n-1]


if __name__ == '__main__':
    pass


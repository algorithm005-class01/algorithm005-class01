"""51. N-Queens

n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。



上图为 8 皇后问题的一种解法。

给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

示例:

输入: 4
输出: [
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
"""


class Solution(object):
    def solve_n_queens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        res = []

        def dfs(queens, xy_diff, xy_sum):
            row = len(queens)
            if row == n:
                res.append(queens)
                return
            for col in xrange(n):
                if col not in queens and row - col not in xy_diff and row + col not in xy_sum:
                    dfs(queens + [col], xy_diff + [row - col], xy_sum + [row + col])
        dfs([], [], [])
        return [['.' * c + 'Q' + '.' * (n - c - 1) for c in col] for col in res]

from typing import List


class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
    #     if not board or not board[0]:
    #         return None
    #     m = len(board)
    #     n = len(board[0])
    #     for i in range(m):
    #         for j in range(n):
    #             if 0 < i < m - 1 and 0 < j < n - 1 and board[i][j] == "o":
    #                 self.dfs(i, j, m, n, board)


    # def dfs(self, i, j, m, n, board):
    #     if board[i][j] == "o":
    #         board[i][j] = "x"
    #         for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
    #             x = dx + i
    #             y = dy + j
    #             if 0 < x < m - 1 and 0 < y < n - 1 and board[x][y] == "o":
    #                 board[x][y] = "x"
    #                 self.dfs(x, y, m, n, board)
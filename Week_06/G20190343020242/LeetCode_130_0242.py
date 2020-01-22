#
# @lc app=leetcode.cn id=130 lang=python3
#
# [130] 被围绕的区域
#
# https://leetcode-cn.com/problems/surrounded-regions/description/
#
# algorithms
# Medium (38.33%)
# Likes:    136
# Dislikes: 0
# Total Accepted:    18.6K
# Total Submissions: 48.2K
# Testcase Example:  '[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]'
#
# 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
#
# 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
#
# 示例:
#
# X X X X
# X O O X
# X X O X
# X O X X
#
#
# 运行你的函数后，矩阵变为：
#
# X X X X
# X X X X
# X X X X
# X O X X
#
#
# 解释:
#
# 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O'
# 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
#
#
from typing import List

# @lc code=start
class Solution:

    def solve(self, board: List[List[str]]) -> None:
        """
        1. 处理四个边上的 'O'
        """
        if not board or not len(board):
            return []

        row, col = len(board), len(board[0])

        def dfs(board, i, j):
            if i < 0 or j < 0 or i >= row or j >= col or board[i][j] == 'X' or board[i][
                    j] == '#':
                return
            board[i][j] = '#'
            dfs(board, i - 1, j)
            dfs(board, i + 1, j)
            dfs(board, i, j - 1)
            dfs(board, i, j + 1)

        for i in range(row):
            for j in range(col):
                isEdge = i == 0 or j == 0 or i == row - 1 or j == col - 1
                if isEdge and board[i][j] == 'O':
                    dfs(board, i, j)

        for i in range(row):
            for j in range(col):
                if board[i][j] == 'O':
                    board[i][j] = 'X'
                if board[i][j] == '#':
                    board[i][j] = 'O'


# @lc code=end

from typing import List


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        def DFS(queens, left, right):
            row = len(queens)
            if row == n:
                result.append(queens)
                return None
            for col in range(n):
                if col not in queens and row - col not in left and row + col not in right:
                    DFS(queens + [col], left + [row - col], right + [row + col])
        result = []
        DFS([], [], [])
        return [['.' * i + 'Q' + '.' * (n - i - 1) for i in row] for row in result]
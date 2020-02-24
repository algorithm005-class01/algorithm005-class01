from typing import List


class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        row = [set(range(1, 10)) for _ in range(9)]
        col = [set(range(1, 10)) for _ in range(9)]
        block = [set(range(1, 10)) for _ in range(9)]

        m = len(board)
        n = len(board[0])
        empty = []
        for i in range(m):
            for j in range(n):
                if board[i][j] != ".":
                    val = int(board[i][j])
                    row[i].remove(val)
                    col[j].remove(val)
                    block[(i // 3) * 3 + j // 3].remove(val)
                else:
                    empty.append((i, j))
        self.dfs(board, row, col, block, empty)
    

    def dfs(self, board, row, col, block, empty, iter=0):
        if len(empty) == iter:
            return True
        i, j = empty[iter]
        b = (i // 3) * 3 + j // 3
        for val in row[i] & col[j] & block[b]:
            row[i].remove(val)
            col[j].remove(val)
            block[b].remove(val)
            board[i][j] = str(val)
            if self.dfs(board, row, col, block, empty, iter + 1):
                return True
            row[i].add(val)
            col[j].add(val)
            block[b].add(val)
        return False

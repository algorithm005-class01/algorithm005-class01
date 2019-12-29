from typing import List


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        def DFS(queens, left_diagonal, right_diagonal):
            row = len(queens)
            if row >= n:
                result.append(queens)
            else:
                for col in range(n):
                    if col not in queens and col + row not in left_diagonal and col - row not in right_diagonal:
                        DFS(queens + [col], left_diagonal + [row + col], right_diagonal + [row - col])

        result = []
        DFS([], [], [])
        return [['.'*i + 'Q' + '.'*(n-i-1) for i in sol] for sol in result]


if __name__ == '__main__':
    solution = Solution()
    print(solution.solveNQueens(4))
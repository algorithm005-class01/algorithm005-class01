class Solution:
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
    return len(result)
        
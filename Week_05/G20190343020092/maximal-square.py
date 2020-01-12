class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        #边界条件
        if not matrix: return 0
        row = len(matrix)
        col = len(matrix[0])
        dp = [0] * (row + 1)
        for i in range(row+1):
            dp[i] = [0] * (col+1)
    
        res = 0
        for i in range(1, row +1):
            for j in range(1, col + 1):
                #只有当二维矩阵当前元素为 1 时，才需要进行判断
                if matrix[i - 1][j - 1] == "1":
                    dp[i][j] = min(dp[i-1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1
                    res = max(res, dp[i][j] ** 2)
        return res


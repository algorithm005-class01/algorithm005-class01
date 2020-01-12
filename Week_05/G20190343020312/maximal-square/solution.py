class Solution:
    def maximalSquare(self, matrix):
        if(not matrix):
            return 0
        m=len(matrix)
        n=len(matrix[0])
        res=0
        pre=0
        dp=[0]*(n+1) 
        for i in range(0,m):
            for j in range(1,n+1):
                tmp=dp[j]
                if(matrix[i][j-1]=="1"):
                    dp[j]=min(pre,dp[j-1],dp[j])+1
                    res=max(dp[j],res)
                else:
                    dp[j]=0
                pre=tmp
            pre=0
        return res*res

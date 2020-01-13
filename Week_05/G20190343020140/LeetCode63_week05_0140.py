#解法1，DP 二维数组，复用参数，自顶向下，把第一行和第一列先处理，有障碍物就全变成1
class Solution(object):
    def uniquePathsWithObstacles(self, obstacleGrid):
        """
        :type obstacleGrid: List[List[int]]
        :rtype: int
        """
        if obstacleGrid[0][0] == 1:
            return 0
       
        n,m = len(obstacleGrid), len(obstacleGrid[0])
        dp =[[0 for _ in range(m)] for _ in range(n)]
        dp[0][0] = 1 - obstacleGrid[0][0]
        for i in range(1,m):
            dp[0][i] = dp[0][i-1] * (1 - obstacleGrid[0][i])
        for j in range(1,n):
            dp[j][0] = dp[j-1][0] * (1 - obstacleGrid[j][0])
    
        for i in range(1,n):
            for j in range(1,m):
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) * (1 - obstacleGrid[i][j])
        return dp[-1][-1]

#解法2，DP 二维数组，原地操作，自顶向下，把第一行和第一列先处理，有障碍物就全变成1
class Solution(object):
    def uniquePathsWithObstacles(self, obstacleGrid):
        """
        :type obstacleGrid: List[List[int]]
        :rtype: int
        """
        col = len(obstacleGrid)
        row = len(obstacleGrid[0])
        if obstacleGrid[0][0] == 1:
            return 0
        obstacleGrid[0][0] = 1
        for i in range(1,col):
            obstacleGrid[i][0]=int(obstacleGrid[i][0] == 0 and obstacleGrid[i-1][0] == 1)
        for j in range(1,row):
            obstacleGrid[0][j]=int(obstacleGrid[0][j] == 0 and obstacleGrid[0][j-1] == 1)
        for i in range (1,col):
            for j in range(1,row):
                if obstacleGrid[i][j] == 0:
                    obstacleGrid[i][j] = obstacleGrid[i][j-1] + obstacleGrid[i-1][j]
                else:
                    obstacleGrid[i][j] = 0
        return obstacleGrid[-1][-1]

#解法3，优化成一维数组，自顶向下
class Solution(object):
    def uniquePathsWithObstacles(self, obstacleGrid):
        """
        :type obstacleGrid: List[List[int]]
        :rtype: int
        """
        if obstacleGrid[0][0] == 1:
            return 0
       
        n,m = len(obstacleGrid), len(obstacleGrid[0])
        
        cur = [0] * m
        cur[0] = 1 - obstacleGrid[0][0]
        for i in range(1,m):
            cur[i] = cur[i-1] * (1 - obstacleGrid[0][i])
        for i in range(1,n):
            cur[0] *=  (1 - obstacleGrid[i][0])
    
            for j in range(1,m):
            
                cur[j] = (cur[j] + cur[j-1]) * (1 - obstacleGrid[i][j])
        return cur[-1]

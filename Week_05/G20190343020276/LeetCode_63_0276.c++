class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        int row = obstacleGrid.size();
        int column = obstacleGrid[0].size();

        if(row == 0 || column == 0)
            return 0;
        if(obstacleGrid[0][0] == 1)
            return 0;
    
        vector<vector<long>> dp(row,vector<long>(column,0));
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                if(i==0 && j==0)
                {
                    dp[i][j] = 1;
                }
                else if(i==0 && j!=0)
                {
                    dp[i][j] = (obstacleGrid[i][j] == 1? 0:dp[i][j-1]);
                }
                else if(i!=0 && j==0)
                {
                    dp[i][j] = (obstacleGrid[i][j] == 1? 0:dp[i-1][j]);
                }
                else
                {
                    dp[i][j] = (obstacleGrid[i][j] == 1? 0:dp[i][j-1] + dp[i-1][j]);
                }
            }
        }
        return dp[row-1][column-1];
    }
};
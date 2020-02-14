class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) 
    {
        // 自底向上
        // 定义状态 
        // 动态转移方程 dp[i,i] = min(dp[i+1][j+1],dp[i+1][j]) + triangle[i][j]
        
        for(int i=triangle.size()-2;i>=0;i--)
        {
            for(int j=0;j<triangle[i].size();j++)
            {
                triangle[i][j] = min(triangle[i+1][j+1],triangle[i+1][j]) + triangle[i][j];
            }
        }
        return triangle[0][0];
    }
};
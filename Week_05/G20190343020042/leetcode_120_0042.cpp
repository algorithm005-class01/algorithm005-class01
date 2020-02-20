class Solution {
public:
	
    int minimumTotal(vector<vector<int>>& triangle) {
        vector<vector<int>> dp(triangle);
        for(int i=triangle.size()-2; i>=0; i--) 
            for(int j=0; j<triangle[i].size(); j++) 
                dp[i][j] = min(dp[i+1][j],dp[i+1][j+1]) + dp[i][j];
        return dp[0][0];
    }
};
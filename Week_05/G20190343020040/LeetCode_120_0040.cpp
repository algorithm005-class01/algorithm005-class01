class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        int rowSize = triangle.size();
        vector<int> dp(triangle[rowSize-1]);
        for(int i = (triangle.size()-2) ; i >= 0 ; i--) {
            for( int j = 0; j < (triangle[i].size()) ; j++ ){
                dp[j] = (min(dp[j], dp[j+1]) + triangle[i][j]);
            }
        }
        return dp[0];
    }
};
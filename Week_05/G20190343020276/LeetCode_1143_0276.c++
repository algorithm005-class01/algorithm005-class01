class Solution {
public:
    int longestCommonSubsequence(string text1, string text2) {
        
        if(text1.empty() || text2.empty())
            return 0;
        int row = text1.size();
        int column = text2.size();
        
        //一定要用升维的方式来解决
        //创建二维的动态规划表
        vector<vector<int>> dp(row+1,vector<int>(column+1));

        //创建一个边界全为0的数组，将这些边界作为动态规划的最小子问题
        for(int i=0;i<column;i++) dp[0][i] = 0;
        for(int i=0;i<row;i++) dp[i][0] = 0;

        //找重复性和子问题，定义状态转移方程（递推方式）
        //比较最后一个字符
        //如果最后一个字符相同，则LCS[i][j] = LCS[i-1][j-1] + 1
        //如果最后一个字符不相同，则LCS[i][j] = max(LCS[i-1,j],LCS[i,j-1])
        for(int i=1;i<=row;i++)
        {
            for(int j=1;j<=column;j++)
            {
                if(text1[i-1] == text2[j-1])
                {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else
                {
                    dp[i][j] = max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[row][column];
    }
};
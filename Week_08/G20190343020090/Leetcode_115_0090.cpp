class Solution {
public:
    int numDistinct(string s, string t) {
        vector<vector<long long>> dp(t.size() + 1, vector<long long>(s.size() + 1, 0));
        for (int j = 0; j < s.size() + 1; j++)
            dp[0][j] = 1;
        for (int i = 1; i < t.size() + 1; i++)
        {
            for (int j = 1; j < s.size() + 1; j++)
            {
                if (t[i-1] == s[j-1])
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                else
                    dp[i][j] = dp[i][j-1];
            }

        }
        return dp[t.size()][s.size()];

    }
};
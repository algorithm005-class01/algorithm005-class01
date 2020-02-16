class Solution {
public:
    int numDecodings(string s) {
        if(s.size() == 0 || (s.size() == 1 && s[0] == '0'))
            return 0;
        if(s.size() == 1)
            return 1;

        vector<int> dp(s.size() + 1, 0);

        dp[0] = 1;
        
        for(int i = 0; i < s.size(); ++i)
        {
            dp[i+1] = (s[i] == '0') ? 0 : dp[i];
            if(i > 0 && (s[i-1] == '1' || (s[i-1] == '2' && s[i] <= '6')))
            {
                dp[i+1] += dp[i-1];
            }
        }
        return dp.back();  
    }
};
class Solution {
public:
    int longestValidParentheses(string s) {
        int size = s.length();
        if(size==0) return 0;
        int dp[size] = {0};
        int maxLength = 0;
        for (int i = 1; i < size; i++) {
            if (s[i] == ')') {
                int p = i - dp[i - 1] - 1;
                if (p >= 0 && s[p] == '(') {
                    dp[i] += (dp[i - 1] + 2);
                    if (p > 1) {
                        dp[i] += dp[p - 1];
                    }
                }
                maxLength = fmax(maxLength, dp[i]);
            }
        }
        return maxLength;
    }
};
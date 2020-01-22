#include <string>
using namespace std;


//这道题没啥可说的，就是最最简单的dp情况
int longestValidParentheses(string s)
{
    if (s.size() == 0)
	return 0;
    int maxans = 0;
    int dp[s.length()];
    for (int i = 0; i < s.length(); ++i) {
	dp[i] = 0;
    }
    for (int i = 1; i < s.length(); i++) {
	if (s[i] == ')') {
	    if (s[i - 1] == '(') {
		dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
	    } else if (i - dp[i - 1] > 0 && s[i - dp[i - 1] - 1] == '(') {
		dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
	    }
	    maxans = max(maxans, dp[i]);
	}
    }
    return maxans;
}

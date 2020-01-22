#include <string>
using namespace std;

int numDecodings(string s)
{
    if (s.size() == 0)
	return 0;
    long long dp[s.size() + 1];
    dp[s.size()] = 1; //当存储解码方法
    for (int i = s.size() - 1; i >= 0; --i) {
	if (s[i] == '0') {
	    dp[i] = 0;
	} else if (s[i] == '1') {
	    dp[i] = dp[i + 1];
	    if (i + 2 < s.size() + 1) {
		dp[i] += dp[i + 2];
	    }
	} else if (s[i] == '2') {
	    dp[i] = dp[i + 1];
	    if (i + 2 < s.size() + 1 && s[i + 1] <= '6') {
		dp[i] += dp[i + 2];
	    }
	} else {
	    dp[i] = dp[i + 1];
	}
    }
    return dp[0];
}

package g20190343020320

// 44.通配符匹配
// https://leetcode-cn.com/problems/wildcard-matching/

// DP
func IsMatch_44_1(s string, p string) bool {
	dp := make([][]bool, len(p)+1)
	dp[0] = make([]bool, len(s)+1)
	dp[0][0] = true

	for i := 1; i <= len(p); i++ {
		dp[i] = make([]bool, len(s)+1)
		dp[i][0] = p[i-1] == '*' && dp[i-1][0]
		for j := 1; j <= len(s); j++ {
			if p[i-1] == '*' {
				dp[i][j] = dp[i-1][j] || dp[i][j-1]
			} else {
				dp[i][j] = dp[i-1][j-1] && (p[i-1] == '?' || p[i-1] == s[j-1])
			}
		}
	}

	return dp[len(p)][len(s)]
}

// 空间复杂度优化
func IsMatch_44_2(s string, p string) bool {
	dp, cache := make([]bool, len(s)+1), false
	dp[0] = true

	for i := 1; i <= len(p); i++ {
		dp[0], cache = p[i-1] == '*' && dp[0], dp[0]
		for j := 1; j <= len(s); j++ {
			if p[i-1] == '*' {
				dp[j], cache = dp[j] || dp[j-1], dp[j]
			} else {
				dp[j], cache = cache && (p[i-1] == '?' || p[i-1] == s[j-1]), dp[j]
			}
		}
	}

	return dp[len(s)]
}

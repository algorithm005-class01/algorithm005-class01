package g20190343020320

// 115.不同的子序列
// https://leetcode-cn.com/problems/distinct-subsequences/

// DP解法
func NumDistinct_1(s string, t string) int {
	dp := make([][]int, len(t)+1)
	dp[0] = make([]int, len(s)+1)
	for j := 0; j <= len(s); j++ {
		dp[0][j] = 1
	}
	for i := 1; i <= len(t); i++ {
		dp[i] = make([]int, len(s)+1)
		for j := i; j <= len(s); j++ {
			dp[i][j] = dp[i][j-1]
			if t[i-1] == s[j-1] {
				dp[i][j] += dp[i-1][j-1]
			}
		}
	}
	return dp[len(t)][len(s)]
}

// 空间复杂度优化
func NumDistinct_2(s string, t string) int {
	dp, cache := make([]int, len(s)+1), 0
	for j := 0; j <= len(s); j++ {
		dp[j] = 1
	}
	for i := 1; i <= len(t); i++ {
		cache, dp[i-1] = dp[i-1], 0
		for j := i; j <= len(s); j++ {
			if t[i-1] == s[j-1] {
				dp[j], cache = dp[j-1]+cache, dp[j]
			} else {
				dp[j], cache = dp[j-1], dp[j]
			}
		}
	}
	return dp[len(s)]
}

package g20190343020320

// 5.最长回文子串
// https://leetcode-cn.com/problems/longest-palindromic-substring/

func LongestPalindrome(s string) string {
	if len(s) < 2 {
		return s
	}

	dp, max, p := make([][]bool, len(s)), 0, 0
	for i := len(s) - 1; i >= 0; i-- {
		dp[i] = make([]bool, len(s))
		for j := i; j < len(s); j++ {
			dp[i][j] = s[i] == s[j] && ((j-i) < 2 || dp[i+1][j-1])
			if dp[i][j] && j-i+1 >= max {
				max, p = j-i+1, i
			}
		}
	}

	return s[p : p+max]
}

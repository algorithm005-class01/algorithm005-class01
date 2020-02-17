package g20190343020320

// 10.正则表达式匹配
// https://leetcode-cn.com/problems/regular-expression-matching/

// 解法1: 递归 / DFS
func IsMatch_10_1(s string, p string) bool {
	if len(p) == 0 {
		return len(s) == 0
	}

	if len(p) > 1 && p[1] == '*' {
		if p[0] != '.' && (len(s) == 0 || s[0] != p[0]) {
			return IsMatch_10_1(s, p[2:])
		}
		return IsMatch_10_1(s, p[2:]) || len(s) > 0 && IsMatch_10_1(s[1:], p)
	}

	if len(s) == 0 || p[0] != '.' && s[0] != p[0] {
		return false
	}

	return IsMatch_10_1(s[1:], p[1:])
}

// 解法2: DP
// DP方程：
// 在 当前字符 p[i] 等于 "*" 时，dp[i][j] 就等于字串 px* 的子串(p 或 px)是否和字串 sy 的子串 s 匹配，且字串 px* 的前一个字符 x 是否和字串 sy 的当前字符 y 匹配
// 在 当前字符 p[i] 不等于 "*" 时，dp[i][j] 就等于字串 px 的子串 p 是否和字串 sy 的子串 s 匹配，且字串 px 的当前字符 x 是否和字串 sy 的当前字符 y 匹配
func IsMatch_10_2(s string, p string) bool {
	dp := make([][]bool, len(p)+1)
	dp[0] = make([]bool, len(s)+1)
	dp[0][0] = true

	for i := 1; i <= len(p); i++ {
		dp[i] = make([]bool, len(s)+1)
		dp[i][0] = i > 1 && p[i-1] == '*' && dp[i-2][0]
		for j := 1; j <= len(s); j++ {
			if i > 1 && p[i-1] == '*' {
				dp[i][j] = dp[i-2][j] || dp[i-1][j] || dp[i][j-1] && (p[i-2] == '.' || p[i-2] == s[j-1])
			} else {
				dp[i][j] = dp[i-1][j-1] && (p[i-1] == '.' || s[j-1] == p[i-1])
			}
		}

	}

	return dp[len(p)][len(s)]
}

// 解法2空间复杂度优化
func IsMatch_10_2_2(s string, p string) bool {
	if len(p) == 0 {
		return len(s) == 0
	}

	dp := make([][]bool, 2)
	dp[0], dp[1] = make([]bool, len(s)+1), make([]bool, len(s)+1)

	dp[0][0] = true
	for j := 1; j <= len(s); j++ {
		dp[1][j] = dp[0][j-1] && (p[0] == '.' || p[0] == s[j-1])
	}

	for i := 2; i <= len(p); i++ {
		cache := make([]bool, len(s)+1)
		cache[0] = p[i-1] == '*' && dp[0][0]
		for j := 1; j <= len(s); j++ {
			if p[i-1] == '*' {
				cache[j] = dp[0][j] || dp[1][j] || cache[j-1] && (p[i-2] == '.' || p[i-2] == s[j-1])
			} else {
				cache[j] = dp[1][j-1] && (p[i-1] == '.' || p[i-1] == s[j-1])
			}
		}
		dp[0], dp[1] = dp[1], cache
	}

	return dp[1][len(s)]
}

// 解法2空间复杂度再优化
// 额外内存空间为: 2 * (s.Lenght + 1)
func IsMatch_10_2_3(s string, p string) bool {
	if len(p) == 0 {
		return len(s) == 0
	}

	dp := make([][]bool, 2)
	dp[0], dp[1] = make([]bool, len(s)+1), make([]bool, len(s)+1)

	dp[0][0] = true
	for j := 1; j <= len(s); j++ {
		dp[1][j] = dp[0][j-1] && (p[0] == '.' || p[0] == s[j-1])
	}

	for i := 2; i <= len(p); i++ {
		dp[0][0], dp[1][0] = dp[1][0], p[i-1] == '*' && dp[0][0]
		for j := 1; j <= len(s); j++ {
			if p[i-1] == '*' {
				dp[0][j], dp[1][j] = dp[1][j], dp[0][j] || dp[1][j] || dp[1][j-1] && (p[i-2] == '.' || p[i-2] == s[j-1])
			} else {
				dp[0][j], dp[1][j] = dp[1][j], dp[0][j-1] && (p[i-1] == '.' || p[i-1] == s[j-1])
			}
		}
	}

	return dp[1][len(s)]
}

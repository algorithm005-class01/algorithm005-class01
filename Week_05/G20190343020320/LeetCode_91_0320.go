package g20190343020320

// 91.解码方法
// https://leetcode-cn.com/problems/decode-ways/

// 判断逻辑复杂
func NumDecodings(s string) int {
	dp := make([]int, len(s))

	if len(s) == 0 || s[0] == '0' {
		return 0
	}
	dp[0] = 1
	for i := 1; i < len(s); i++ {
		if s[i] == '0' {
			if s[i-1] != '1' && s[i-1] != '2' {
				return 0
			} else if i > 1 && (s[i-2] == '1' || s[i-2] == '2') {
				dp[i] = dp[i-2]
			} else {
				dp[i] = dp[i-1]
			}
		} else if s[i-1] == '1' || (s[i-1] == '2' && s[i] < '7') {
			if i < 2 {
				dp[i] = dp[i-1] + 1
			} else {
				dp[i] = dp[i-1] + dp[i-2]
			}
		} else {
			dp[i] = dp[i-1]
		}
	}

	return dp[len(s)-1]
}

// 逆向
// 逻辑还需要精简
func NumDecodings_2(s string) int {
	if len(s) == 0 || s[0] == '0' {
		return 0
	}

	a, b := 1, 1
	for i := len(s) - 2; i >= 0; i-- {
		if s[i] == '0' {
			if s[i+1] == '0' {
				return 0
			}
			a, b = b, b
		} else if s[i] == '1' || (s[i] == '2' && s[i+1] < '7') {
			if s[i+1] == '0' || (i < len(s)-2 && s[i+2] == '0') {
				a, b = b, b
			} else {
				a, b = b, a+b
			}
		} else {
			if s[i+1] == '0' {
				return 0
			}
			a, b = b, b
		}
	}

	return b
}

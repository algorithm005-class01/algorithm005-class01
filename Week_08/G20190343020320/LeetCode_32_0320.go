package g20190343020320

// 32.最长有效括号
// https://leetcode-cn.com/problems/longest-valid-parentheses/

func LongestValidParentheses(s string) int {
	dp, max := make([]int, len(s)+1), 0

	for i := 2; i < len(dp); i++ {
		if s[i-1] == ')' {
			if s[i-2] == '(' {
				dp[i] = dp[i-2] + 2
			} else if k := i - dp[i-1] - 1; k > 0 && s[k-1] == '(' {
				dp[i] = dp[i-1] + 2
				if k-1 > 0 {
					dp[i] += dp[k-1]
				}
			}

			if dp[i] > max {
				max = dp[i]
			}
		}
	}

	return max
}

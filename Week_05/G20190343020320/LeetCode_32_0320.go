package g20190343020320

// 32.最长有效括号
// https://leetcode-cn.com/problems/longest-valid-parentheses/

// 栈
func LongestValidParentheses(s string) int {
	l, max := len(s), 0
	if l < 2 {
		return max
	}

	stack := []int{-1}
	for i := 0; i < l; i++ {
		if s[i] == '(' {
			stack = append(stack, i)
		} else {
			stack = stack[:len(stack)-1]
			if len(stack) == 0 {
				stack = append(stack, i)
			} else {
				max = intMax(i-stack[len(stack)-1], max)
			}
		}
	}

	return max
}

// dp
func LongestValidParentheses_2(s string) int {
	l, max := len(s), 0
	if l < 2 {
		return max
	}

	dp := make([]int, l)
	for i := 1; i < l; i++ {
		if s[i] == ')' {
			if s[i-1] == '(' {
				dp[i] = 2
				if i-2 > dp[i-1] {
					dp[i] += dp[i-2-dp[i-1]]
				}
			} else if i-1 >= dp[i-1] && s[i-1-dp[i-1]] == '(' {
				dp[i] = dp[i-1] + 2
				if dp[i-1] != 0 && i-2 >= dp[i-1] {
					dp[i] += dp[i-2-dp[i-1]]
				}
			}
			max = intMax(dp[i], max)
		}
	}

	return max
}

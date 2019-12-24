package g20190343020320

// 22.括号生成
// https://leetcode-cn.com/problems/generate-parentheses/
func GenerateParenthesis(n int) []string {
	return generateParenthesis(0, 0, n, "")
}

func generateParenthesis(l, r, n int, s string) (re []string) {
	if l == n && l == r {
		return append(re, s)
	}

	if l < n {
		re = append(re, generateParenthesis(l+1, r, n, s+"(")...)
	}
	if r < l {
		re = append(re, generateParenthesis(l, r+1, n, s+")")...)
	}

	return re
}

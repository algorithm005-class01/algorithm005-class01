package g20190343020320

// 680.验证回文字符串ii
// https://leetcode-cn.com/problems/valid-palindrome-ii/

func ValidPalindrome(s string) bool {
	return isPrime(s, true)
}

func isPrime(s string, k bool) bool {
	for p, q := 0, len(s)-1; p < q; p, q = p+1, q-1 {
		if s[p] != s[q] {
			if k {
				return isPrime(s[p:q], false) || isPrime(s[p+1:q+1], false)
			}
			return false
		}
	}
	return true
}

package g20190343020320

// 91.解码方法
// https://leetcode-cn.com/problems/decode-ways/

func NumDecodings(s string) int {
	if len(s) == 0 || s[0] == '0' {
		return 0
	}

	a, b := 1, 1
	for i := 1; i < len(s); i++ {
		if s[i] == '0' && s[i-1] != '1' && s[i-1] != '2' {
			return 0
		}

		if s[i] == '0' && isAcc_91(s, i-1) {
			a, b = b-a, a
			continue
		}

		if isAcc_91(s, i) {
			a, b = b, a+b
		} else {
			a = b
		}
	}
	return b
}

func isAcc_91(s string, i int) bool {
	return i > 0 && s[i] != '0' && (s[i] < '7' && s[i-1] != '0' && s[i-1] < '3' || s[i-1] == '1')
}

package g20190343020320

// 917.仅仅反转字母
// https://leetcode-cn.com/problems/reverse-only-letters/

func ReverseOnlyLetters(S string) string {
	arr := make([]byte, len(S))
	for i, j := 0, len(S)-1; i <= j; {
		if a, b := ('a' > S[i] || S[i] > 'z') && ('A' > S[i] || S[i] > 'Z'), ('a' > S[j] || S[j] > 'z') && ('A' > S[j] || S[j] > 'Z'); !a && !b {
			arr[i], arr[j] = S[j], S[i]
			i, j = i+1, j-1
		} else {
			if a {
				arr[i] = S[i]
				i++
			}
			if b {
				arr[j] = S[j]
				j--
			}
		}
	}
	return string(arr)
}

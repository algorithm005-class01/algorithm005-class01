package g20190343020320

// 151.翻转字符串里的单词
// https://leetcode-cn.com/problems/reverse-words-in-a-string/

func reverseWords(s string) string {
	if len(s) < 1 {
		return ""
	}
	arr, str, k := [][]byte{}, []byte{}, 0
	for i := 0; i < len(s); i++ {
		if s[i] == ' ' {
			if len(str) > 0 {
				arr, str = append(arr, str), []byte{}
			}
		} else {
			str = append(str, s[i])
		}
	}
	if len(str) > 0 {
		arr = append(arr, str)
	}
	if len(arr) < 1 {
		return ""
	}
	str = make([]byte, len(s)+1)
	for i := 0; i < len(arr); i, k = i+1, k+1 {
		a := arr[len(arr)-i-1]
		for j := 0; j < len(a); j, k = j+1, k+1 {
			str[k] = a[j]
		}
		str[k] = ' '
	}
	return string(str[:k-1])
}

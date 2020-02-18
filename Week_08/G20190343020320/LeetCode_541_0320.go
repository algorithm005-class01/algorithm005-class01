package g20190343020320

// 541.反转字符串ii
// https://leetcode-cn.com/problems/reverse-string-ii/

func ReverseStr(s string, k int) string {
	n, arr := len(s)/(2*k), make([]byte, len(s))

	for k := range s {
		arr[k] = s[k]
	}

	for i := 0; i < n; i++ {
		for j := 0; j < (k >> 1); j++ {
			a, b := j+(i*2*k), k-j-1+(i*2*k)
			arr[a], arr[b] = arr[b], arr[a]
		}
	}

	tail, tailk := (n * 2 * k), k
	if f := len(s) % (2 * k); f < k {
		tailk = f
	}

	for i := 0; i < (tailk >> 1); i++ {
		a, b := i+tail, tailk-i-1+tail
		arr[a], arr[b] = arr[b], arr[a]
	}

	return string(arr)
}

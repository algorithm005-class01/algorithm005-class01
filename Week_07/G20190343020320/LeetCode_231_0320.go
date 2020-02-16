package g20190343020320

// 231.2的幂
// https://leetcode-cn.com/problems/power-of-two/

func IsPowerOfTwo(n int) bool {
	if n < 1 {
		return false
	}

	for ; n != 0; n >>= 1 {
		if n&1 == 1 {
			break
		}
	}

	return n == 1
}

// 解法2
func IsPowerOfTwo2(n int) bool {
	return n != 0 && n&(n-1) == 0
}

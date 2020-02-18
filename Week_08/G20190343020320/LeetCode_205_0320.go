package g20190343020320

// 205.同构字符串
// https://leetcode-cn.com/problems/isomorphic-strings/

func IsIsomorphic(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	cache, temp := make([]byte, 256), make([]bool, 257)
	for i := 0; i < len(s); i++ {
		if a, b := s[i], t[i]+1; cache[a] == 0 && !temp[b] {
			cache[a], temp[b] = b, true
			continue
		}

		if cache[s[i]] != t[i]+1 {
			return false
		}
	}
	return true
}

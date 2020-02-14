package g20190343020320

// 242.有效字母异位
// https://leetcode-cn.com/problems/valid-anagram/

func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	str := [26]rune{}
	for i := 0; i < len(s); i++ {
		str[s[i]-'a']++
		str[t[i]-'a']--
	}

	for _, v := range str {
		if v != 0 {
			return false
		}
	}

	return true
}

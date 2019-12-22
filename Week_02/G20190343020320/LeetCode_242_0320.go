package g20190343020320

// 242.有效字母异位词
// https://leetcode-cn.com/problems/valid-anagram/
func IsAnagram(s, t string) bool {
	if len(s) != len(t) {
		return false
	}
	return anag(s) == anag(t)
}

// 遍历字符串，返回按字母计算 Array 转 String
func anag(s string) string {
	arr := make([]rune, 26)
	for _, v := range s {
		arr[v-'a']++
	}
	return string(arr)
}

package g20190343020320

// 58.最后一个单词的长度
// https://leetcode-cn.com/problems/length-of-last-word/

func LengthOfLastWord(s string) int {
	i, k := 0, len(s)
	for ; i < len(s); i++ {
		if s[len(s)-i-1] != ' ' && k == len(s) {
			k = i
		}

		if s[len(s)-i-1] == ' ' && k != len(s) {
			return i - k
		}
	}
	return i - k
}

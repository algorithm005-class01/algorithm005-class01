package g20190343020320

// 387.字符串中第一个唯一字符
// https://leetcode-cn.com/problems/first-unique-character-in-a-string/

func FirstUniqChar(s string) int {
	arr := make([]int, 26)
	for _, v := range s {
		arr[v-'a']++
	}

	for k, v := range s {
		if arr[v-'a'] == 1 {
			return k
		}
	}

	return -1
}

package g20190343020320

// 49.字母异位词分组
// https://leetcode-cn.com/problems/group-anagrams/
func GroupAnagrams(strs []string) [][]string {
	maps := make(map[string][]string, 0)
	for _, v := range strs {
		s := groupAnag(v)
		if _, ok := maps[s]; ok {
			maps[s] = append(maps[s], v)
		} else {
			maps[s] = []string{v}
		}
	}

	re := make([][]string, 0)
	for _, v := range maps {
		re = append(re, v)
	}

	return re
}

func groupAnag(s string) string {
	arr := make([]rune, 26)
	for _, v := range s {
		arr[v-'a']++
	}
	return string(arr)
}

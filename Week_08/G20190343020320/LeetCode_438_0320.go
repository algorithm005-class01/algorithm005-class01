package g20190343020320

// 438.找到字符串中所有字母异位词
// https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/

func FindAnagrams(s string, p string) []int {

	if len(p) < 1 || len(s) < 1 || len(p) > len(s) {
		return []int{}
	}

	tempS, tempP, all := make([]int, 26), make([]int, 26), []int{}
	for k := range p {
		tempP[p[k]-'a']++
		tempS[s[k]-'a']++
	}

	if isT(tempP, tempS) {
		all = append(all, 0)
	}

	for i := 0; i < len(s)-len(p); i++ {
		tempS[s[i+len(p)]-'a']++
		tempS[s[i]-'a']--
		if isT(tempP, tempS) {
			all = append(all, i+1)
		}
	}

	return all
}

func isT(tempP, tempS []int) bool {
	for i := 0; i < 26; i++ {
		if tempP[i] != tempS[i] {
			return false
		}
	}
	return true
}

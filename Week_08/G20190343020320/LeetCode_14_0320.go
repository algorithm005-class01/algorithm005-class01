package g20190343020320

// 14.最长公共前缀
// https://leetcode-cn.com/problems/longest-common-prefix/

func LongestCommonPrefix(strs []string) string {
	if len(strs) < 1 {
		return ""
	}

	reStr := make([]byte, len(strs[0]))
	for k := range strs[0] {
		reStr[k] = strs[0][k]
	}

	for i := 1; i < len(strs); i++ {
		le := minInts(len(reStr), len(strs[i]))
		for j := 0; j < le; j++ {
			if reStr[j] != strs[i][j] {
				le = j
				break
			}
		}
		reStr = reStr[:le]
	}

	return string(reStr)
}

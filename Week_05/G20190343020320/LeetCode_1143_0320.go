package g20190343020320

// 1143.最长公共子序列
// https://leetcode-cn.com/problems/longest-common-subsequence/
func LongestCommonSubsequence(text1 string, text2 string) int {
	l1, l2 := len(text1), len(text2)
	if l1 == 0 || l2 == 0 {
		return 0
	}
	maps := make([][]int, l1)

	for i := 0; i < l1; i++ {
		maps[i] = make([]int, l2)
		for j := 0; j < l2; j++ {
			if i == 0 || j == 0 {
				if (j > 0 && maps[i][j-1] == 1) || (i > 0 && maps[i-1][j] == 1) || text1[i] == text2[j] {
					maps[i][j] = 1
				}
			} else if text1[i] == text2[j] {
				maps[i][j] = maps[i-1][j-1] + 1
			} else {
				maps[i][j] = intMax(maps[i-1][j], maps[i][j-1])
			}
		}
	}

	return maps[l1-1][l2-1]
}

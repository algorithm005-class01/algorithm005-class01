package g20190343020320

// 72.编辑距离
// https://leetcode-cn.com/problems/edit-distance/

// 递推
func MinDistance(word1 string, word2 string) int {
	dp := make([][]int, len(word1)+1)
	for i := 0; i <= len(word1); i++ {
		dp[i] = make([]int, len(word2)+1)
		for j := 0; j <= len(word2); j++ {
			if i == 0 {
				dp[i][j] = j
			} else if j == 0 {
				dp[i][j] = i
			} else {
				if word1[i-1] == word2[j-1] {
					dp[i][j] = dp[i-1][j-1]
				} else {
					dp[i][j] = intMin(intMin(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1
				}
			}
		}
	}

	return dp[len(word1)][len(word2)]
}

// 优化空间复杂度
func MinDistance_2(word1, word2 string) int {

	dp, cache := make([]int, len(word2)+1), 0
	for j := 0; j < len(word2)+1; j++ {
		dp[j] = j
	}
	for i := 0; i < len(word1); i++ {
		cache, dp[0] = i, i+1
		for j := 1; j <= len(word2); j++ {
			if word1[i] == word2[j-1] {
				dp[j], cache = cache, dp[j]
			} else {
				dp[j], cache = intMinTh(dp[j-1], dp[j], cache)+1, dp[j]
			}
		}
	}

	return dp[len(word2)]
}

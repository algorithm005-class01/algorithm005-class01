package g20190343020320

// 72.编辑距离
// https://leetcode-cn.com/problems/edit-distance/

func MinDistance(word1 string, word2 string) int {
	if len(word1) == 0 {
		return len(word2)
	}
	dp, cache := make([]int, len(word2)+1), 0

	for j := 0; j <= len(word2); j++ {
		dp[j] = j
	}
	for i := 0; i < len(word1); i++ {
		dp[0], cache = i+1, dp[0]
		for j := 1; j <= len(word2); j++ {
			if word1[i] == word2[j-1] {
				dp[j], cache = cache, dp[j]
			} else {
				dp[j], cache = minInts(minInts(cache, dp[j]), dp[j-1])+1, dp[j]
			}
		}
	}

	return dp[len(dp)-1]
}

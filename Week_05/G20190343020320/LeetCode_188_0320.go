package g20190343020320

// 188.买卖股票的最佳时机4
// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/

// 空间复杂度为O(k*n*2)
func MaxProfit_188(k int, prices []int) int {
	l := len(prices)
	if l < 2 || k < 1 {
		return 0
	}

	// 当可交易次数 k 超过天数 len(prices) 的一半时，即代表可以无限交易
	if k >= l/2 {
		return MaxProfit_122(prices)
	}

	dp := make([][2][]int, l)

	dp[0][0] = make([]int, k+1)
	dp[0][1] = make([]int, k+1)
	for i := 0; i < k+1; i++ {
		if i == 0 {
			dp[0][1][i] = -prices[0]
		} else {
			dp[0][0][i] = -2147483648
			dp[0][1][i] = -2147483648
		}
	}

	for j := 1; j < l; j++ {
		dp[j][0] = make([]int, k+1)
		dp[j][1] = make([]int, k+1)
		dp[j][1][0] = intMax(-prices[j], dp[j-1][1][0])
		for i := 1; i < k+1; i++ {
			dp[j][0][i] = intMax(dp[j-1][0][i], dp[j-1][1][i-1]+prices[j])
			dp[j][1][i] = intMax(dp[j-1][1][i], dp[j-1][0][i]-prices[j])
		}
	}

	max := 0
	for i := 0; i < k+1; i++ {
		max = intMax(max, dp[l-1][0][i])
	}
	return max
}

// 优化
func MaxProfit_188_2(k int, prices []int) int {
	l := len(prices)
	if l < 2 || k < 1 {
		return 0
	}

	// 当可交易次数 k 超过天数 len(prices) 的一半时，即代表可以无限交易
	if k >= l/2 {
		return MaxProfit_122(prices)
	}

	dp := make([]int, 2*k+1)
	dp[0], dp[1] = 0, -prices[0]
	for i := 1; i < 2*k; i++ {
		dp[i] = -2147483648
	}

	for j := 1; j < l; j++ {
		for i := 1; i < 2*k+1; i += 2 {
			dp[i+1] = intMax(dp[i+1], dp[i]+prices[j])
			dp[i] = intMax(dp[i], dp[i-1]-prices[j])
		}
	}

	return intMax(dp[2*k], 0)
}

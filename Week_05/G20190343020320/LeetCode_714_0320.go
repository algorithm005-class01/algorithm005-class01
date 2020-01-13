package g20190343020320

// 714.买卖股票的最佳时机，含手续费
// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
func MaxProfit_714(prices []int, fee int) int {
	l := len(prices)
	if l < 2 {
		return 0
	}

	dp := make([][2]int, l)
	dp[0][0], dp[0][1] = 0, -prices[0]
	for i := 1; i < l; i++ {
		dp[i][0] = intMax(dp[i-1][0], dp[i-1][1]+prices[i]-fee)
		dp[i][1] = intMax(dp[i-1][1], dp[i-1][0]-prices[i])
	}

	return dp[l-1][0]
}

// 优化
func MaxProfit_714_2(prices []int, fee int) int {
	l := len(prices)
	if l < 2 {
		return 0
	}

	a, b := 0, -prices[0]
	for i := 1; i < l; i++ {
		a, b = intMax(a, b+prices[i]-fee), intMax(b, a-prices[i])
	}

	return a
}

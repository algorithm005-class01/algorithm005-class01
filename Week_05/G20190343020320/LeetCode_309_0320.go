package g20190343020320

// 309.最佳买卖股票时机，含冷冻期
// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

// 双状态递推
func MaxProfit_309(prices []int) int {
	l := len(prices)
	if l < 2 {
		return 0
	}

	dp := make([][2]int, l)
	dp[0][0], dp[0][1] = 0, -prices[0]
	dp[1][0], dp[1][1] = intMax(dp[0][1]+prices[1], dp[0][0]), intMax(dp[0][1], -prices[1])
	for i := 2; i < l; i++ {
		dp[i][0] = intMax(dp[i-1][0], dp[i-1][1]+prices[i])
		dp[i][1] = intMax(dp[i-1][1], dp[i-2][0]-prices[i])
	}
	return intMax(dp[l-1][0], dp[l-1][1])
}

// 逐步优化
func MaxProfit_309_2(prices []int) int {
	l := len(prices)
	if l < 2 {
		return 0
	}

	a, b := 0, -prices[0]
	c, d := intMax(b+prices[1], a), intMax(b, -prices[1])

	for i := 2; i < l; i++ {
		a, b, c, d = c, d, intMax(c, d+prices[i]), intMax(d, a-prices[i])
	}

	return intMax(c, d)
}

// 优化到看不懂了🤦‍♂️
func MaxProfit_309_3(prices []int) int {
	l := len(prices)
	if l < 2 {
		return 0
	}

	a, b, c := 0, intMax(prices[1]-prices[0], 0), intMax(-prices[0], -prices[1])

	for i := 2; i < l; i++ {
		a, b, c = b, intMax(b, c+prices[i]), intMax(c, a-prices[i])
	}

	return b
}

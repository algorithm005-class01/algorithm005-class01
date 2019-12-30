package g20190343020320

// 322.数硬币
// https://leetcode-cn.com/problems/coin-change/

func CoinChange(coins []int, amount int) int {
	if len(coins) == 0 || amount < 1 {
		return 0
	}
	maps = make(map[int]int)
	return dfs322(coins, amount)
}

var maps map[int]int

func dfs322(coins []int, amount int) int {
	if v, ok := maps[amount]; ok {
		return v
	}

	min := -2
	for i := len(coins) - 1; i >= 0; i-- {
		if coins[i] == amount {
			return 1
		} else if coins[i] < amount {
			if r := dfs322(coins, amount-coins[i]); r != -1 {
				if min == -2 || min > r {
					min = r
				}
			}
		}
	}

	maps[amount] = min + 1
	return min + 1
}

// 最优解
func CoinChange2(coins []int, amount int) int {
	n := len(coins)
	dp := make([]int, amount+1)
	for i := 1; i <= amount; i++ {
		dp[i] = amount + 1
	}
	dp[0] = 0
	for i := 1; i <= amount; i++ {
		for j := n - 1; j >= 0; j-- {
			if i-coins[j] >= 0 {
				dp[i] = min(dp[i], dp[i-coins[j]]+1)
			}
		}
	}
	if dp[amount] == amount+1 {
		return -1
	}
	return dp[amount]
}

func min(x, y int) int {
	if x < y {
		return x
	}
	return y
}

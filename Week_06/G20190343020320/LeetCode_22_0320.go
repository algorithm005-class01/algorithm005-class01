package g20190343020320

// 22.括号生成
// https://leetcode-cn.com/problems/generate-parentheses/

// DFS
func GenerateParenthesis(n int) []string {
	cache = []string{}
	dfs(n, 0, 0, "")
	return cache
}

var cache []string

func dfs(n, l, r int, re string) {
	if n == l && l == r {
		cache = append(cache, re)
		return
	}

	if l < n {
		dfs(n, l+1, r, re+"(")
	}

	if r < l {
		dfs(n, l, r+1, re+")")
	}
}

// DP
// DP公式：
//		设 i+j = n-1
// 		有 dp[n] = "(" + dp[i] + ")" + dp[i-j-1]
func GenerateParenthesis2(n int) []string {
	if n < 0 {
		return []string{}
	}
	cache := make([][]string, 2)
	cache[0] = []string{""}
	cache[1] = []string{"()"}

	for i := 2; i <= n; i++ {
		cache = append(cache, []string{})

		for j := 0; j < i; j++ {
			list1 := cache[i-j-1]
			list2 := cache[j]

			for _, l1 := range list1 {
				for _, l2 := range list2 {
					cache[i] = append(cache[i], "("+l1+")"+l2)
				}
			}
		}
	}

	return cache[n]
}

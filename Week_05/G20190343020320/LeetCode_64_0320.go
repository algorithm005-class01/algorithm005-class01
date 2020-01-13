package g20190343020320

// 64.最小路径和
// https://leetcode-cn.com/problems/minimum-path-sum/

// dp
func MinPathSum(grid [][]int) int {
	l := len(grid)
	if l == 0 {
		return 0
	}

	for i := 0; i < l; i++ {
		for j := 0; j < len(grid[i]); j++ {
			if i == 0 {
				if j == 0 {
					continue
				}
				grid[i][j] = grid[i][j-1]
			} else if j == 0 {
				grid[i][j] = grid[i-1][j]
			} else {
				grid[i][j] = intMin(grid[i-1][j], grid[i][j-1])
			}
		}
	}

	return grid[l-1][len(grid[l-1])-1]
}

package g20190343020320

// 200.岛屿的数量
// https://leetcode-cn.com/problems/number-of-islands/
func NumIslands(grid [][]byte) (k int) {
	for i, row := range grid {
		for j, block := range row {
			if block == 1 {
				// DFS
				k++
				dfs200(i, j, grid)
			}
		}
	}
	return
}

func dfs200(i, j int, grid [][]byte) {
	if grid[i][j] == 0 {
		return
	}

	grid[i][j] = 0
	if i < len(grid)-1 {
		dfs200(i+1, j, grid)
	}
	if i > 0 {
		dfs200(i-1, j, grid)
	}
	if j < len(grid[i])-1 {
		dfs200(i, j+1, grid)
	}
	if j > 0 {
		dfs200(i, j-1, grid)
	}
}

// 判断优化
func dfs200_2(i, j int, grid [][]byte) {
	if i == len(grid) || i < 0 || j == len(grid[i]) || j < 0 || grid[i][j] == 0 {
		return
	}

	grid[i][j] = 0
	dfs200_2(i+1, j, grid)
	dfs200_2(i-1, j, grid)
	dfs200_2(i, j+1, grid)
	dfs200_2(i, j-1, grid)
}

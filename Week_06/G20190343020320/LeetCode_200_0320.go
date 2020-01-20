package g20190343020320

// 200.岛屿数量
// https://leetcode-cn.com/problems/number-of-islands/
func NumIslands(grid [][]byte) int {

	if len(grid) == 0 {
		return 0
	}

	u := UnionFindInit2(len(grid), len(grid[0]))

	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[i]); j++ {

			if grid[i][j] == '0' {
				u.Count--
				continue
			}

			if i+1 < len(grid) && grid[i+1][j] == '1' {
				u.union2(i, j, i+1, j)
			}
			if j+1 < len(grid[i]) && grid[i][j+1] == '1' {
				u.union2(i, j, i, j+1)
			}
		}
	}

	return u.Count
}

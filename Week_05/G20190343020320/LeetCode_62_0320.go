package g20190343020320

// 62.不同路径
// https://leetcode-cn.com/problems/unique-paths/

func UniquePaths(m int, n int) int {
	maps := make([][]int, n)
	for y := n - 1; y >= 0; y-- {
		maps[y] = make([]int, m)
		for x := m - 1; x >= 0; x-- {
			if y == n-1 || x == m-1 {
				maps[y][x] = 1
			} else {
				maps[y][x] = maps[y+1][x] + maps[y][x+1]
			}
		}
	}

	return maps[0][0]
}

// 节省空间
func UniquePaths2(m int, n int) int {
	maps := make([]int, m)
	for k := range maps {
		maps[k] = 1
	}
	for y := n - 2; y >= 0; y-- {
		for x := m - 2; x >= 0; x-- {
			maps[x] += maps[x+1]
		}
	}

	return maps[0]
}

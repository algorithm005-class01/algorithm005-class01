package g20190343020320

// 52.N皇后2
// https://leetcode-cn.com/problems/n-queens-ii/

// 位运算解法
func TotalNQueens(n int) int {
	Count_52 = 0
	DFS_52(n, 0, 0, 0, 0)
	return Count_52
}

var Count_52 int

func DFS_52(n, level, col, pie, na int) {
	if level == n {
		Count_52++
		return
	}
	for j := 0; j < n; j++ {
		var a, b, c uint = uint(n + j - level - 1), uint(j + level), uint(j)
		if 1<<a&na|1<<b&pie|1<<c&col == 0 {
			DFS_52(n, level+1, 1<<c|col, 1<<b|pie, 1<<a|na)
		}
	}
}

// 移格子位运算
func DFS_52_2(n, level, col, pie, na int) {
	if level == n {
		Count_52++
		return
	}

	bits := (^(col | pie | na)) & ((1 << uint(n)) - 1)

	for bits != 0 {
		p := bits & -bits
		bits = bits & (bits - 1)
		DFS_52_2(n, level+1, col|p, (pie|p)<<1, (na|p)>>1)
	}
}

package g20190343020320

// 37.解数独
// https://leetcode-cn.com/problems/sudoku-solver/
func SolveSudoku(board [][]byte) {
	row = [9][9]bool{}
	col = [9][9]bool{}
	box = [9][9]bool{}

	for i := 0; i < 9; i++ {
		for j := 0; j < 9; j++ {
			if board[i][j] != '.' {
				num := board[i][j] - '1'
				row[i][num] = true
				col[j][num] = true
				box[(i/3)*3+j/3][num] = true
			}
		}
	}

	DFS_37(board, 0, 0)
}

var row, col, box [9][9]bool

func DFS_37(board [][]byte, i, j int) bool {
	// 终止条件
	if j == 9 {
		j = 0
		if i == 8 {
			return true
		}
		i++
	}

	// 剪枝
	if board[i][j] != '.' {
		return DFS_37(board, i, j+1)
	}

	boxNum := (i/3)*3 + j/3
	for num := 0; num < 9; num++ {
		// 剪枝
		if row[i][num] || col[j][num] || box[boxNum][num] {
			continue
		}

		// 处理当前层
		row[i][num] = true
		col[j][num] = true
		box[boxNum][num] = true
		board[i][j] = byte(num + '1')

		// 下探
		if DFS_37(board, i, j+1) {
			return true
		}

		// 还原
		board[i][j] = '.'
		row[i][num] = false
		col[j][num] = false
		box[boxNum][num] = false
	}

	return false
}

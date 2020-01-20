package g20190343020320

// 36.验证数独
// https://leetcode-cn.com/problems/valid-sudoku/
func isValidSudoku(board [][]byte) bool {

	col := [9][9]bool{}
	row := [9][9]bool{}
	box := [9][9]bool{}

	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board); j++ {

			if board[i][j] == '.' {
				continue
			}

			num := int(board[i][j] - '1')

			// 疑问:
			// 为什么当 board[i][j] == '.' 时，num = 253？ 但 int(board[i][j] - '1') == -3 ???

			if col[j][num] {
				return false
			} else {
				col[j][num] = true
			}

			if row[i][num] {
				return false
			} else {
				row[i][num] = true
			}

			boxNum := (i / 3 * 3) + j/3
			if box[boxNum][num] {
				return false
			} else {
				box[boxNum][num] = true
			}
		}
	}

	return true
}

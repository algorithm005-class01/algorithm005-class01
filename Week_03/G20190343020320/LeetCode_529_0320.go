package g20190343020320

// 529.扫雷游戏
// https://leetcode-cn.com/problems/minesweeper/

var a []int = []int{1, 1, 1, -1, -1, -1, 0, 0}
var b []int = []int{1, 0, -1, 1, 0, -1, 1, -1}
var c []byte = []byte{'1', '2', '3', '4', '5', '6', '7', '8'}

func UpdateBoard(board [][]byte, click []int) [][]byte {
	if len(click) != 2 {
		return board
	}

	i, j := click[0], click[1]

	if i > len(board)-1 || i < 0 || j > len(board[i])-1 || j < 0 {
		return board
	}

	if board[i][j] == 'M' {
		board[i][j] = 'X'
		return board
	} else if board[i][j] == 'E' {
		m := 0
		for k, v := range a {
			ia, jb := i+v, j+b[k]
			if ia < len(board) && ia > -1 && jb < len(board[ia]) && jb > -1 && board[ia][jb] == 'M' {
				m++
			}
		}

		if m != 0 {
			board[i][j] = c[m-1]
			return board
		}

		board[i][j] = 'B'

		for k, v := range a {
			ia, jb := i+v, j+b[k]
			UpdateBoard(board, []int{ia, jb})
		}
	}

	return board
}

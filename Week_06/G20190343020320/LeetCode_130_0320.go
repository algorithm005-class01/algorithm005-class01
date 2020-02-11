package g20190343020320

// 130.被围绕的区域
// https://leetcode-cn.com/problems/surrounded-regions/

func Solve(board [][]byte) {
	if len(board) == 0 {
		return
	}
	p, q := len(board), len(board[0])
	u := UnionFindInit(p*q + 1)

	for i := 0; i < p; i++ {
		for j := 0; j < q; j++ {

			if board[i][j] != 'O' {
				continue
			}

			if i == 0 || i == p-1 || j == 0 || j == q-1 {
				u.union(p*q, i*q+j)
				// continue
			}

			if i < p-1 && board[i+1][j] == 'O' {
				u.union(i*q+j, (i+1)*q+j)
			}

			if j < q-1 && board[i][j+1] == 'O' {
				u.union(i*q+j, i*q+j+1)
			}
		}
	}

	for i := 0; i < p; i++ {
		for j := 0; j < q; j++ {
			if u.find(i*q+j) == u.find(p*q) {
				board[i][j] = 'O'
			} else {
				board[i][j] = 'X'
			}
		}
	}
}

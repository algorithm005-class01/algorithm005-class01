package g20190343020320

// 51.N皇后问题
func SolveNQueens(n int) [][]string {
	reString = [][]string{}
	loopRow([]int{}, n, 0)
	return reString
}

var reString [][]string

func loopRow(m []int, n, i int) {
	if i == n {
		resArr := []string{}
		for _, v := range m {
			resArr = append(resArr, printBoard(n, v))
		}
		reString = append(reString, resArr)
		return
	}

	for j := 0; j < n; j++ {
		l := len(m)
		for k, v := range m {
			if v != j && v != j+l-k && v != j-l+k {
				m = append(m, j)
				loopRow(m, n, i+1)
				m = m[:len(m)-1]
			}
		}
	}
}

func printBoard(n, v int) (resS string) {
	for i := 0; i < n; i++ {
		if i == v {
			resS += "Q"
		} else {
			resS += "."
		}
	}
	return
}

package g20190343020320

// 51.N皇后问题
// https://leetcode-cn.com/problems/n-queens/
func SolveNQueens(n int) [][]string {
	box := make([][]bool, n)
	ret = [][]string{}
	DFS_51(n, 0, box)

	return ret
}

var ret [][]string

func DFS_51(n, level int, box [][]bool) {
	if level == n {
		retArr := make([]string, n)
		for k, b := range box {
			retString := ""
			for _, v := range b {
				if v {
					retString += "Q"
				} else {
					retString += "."
				}
			}
			retArr[k] = retString
		}

		ret = append(ret, retArr)

		return
	}

	for i := 0; i < n; i++ {
		btn := false
		for p := 0; p < level; p++ {
			if box[p][i] || (i-level+p >= 0 && box[p][i-level+p]) || (i+level-p < n && box[p][i+level-p]) {
				// continue 外层循环
				btn = true
				break
			}
		}

		if btn {
			continue
		}

		cache := make([]bool, n)
		cache[i] = true
		box[level] = cache

		DFS_51(n, level+1, box)
	}
}

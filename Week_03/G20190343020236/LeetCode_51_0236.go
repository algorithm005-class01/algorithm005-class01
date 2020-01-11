package main

import "fmt"

func main() {
	fmt.Println(solveNQueens(8))
}

/*
 * @lc app=leetcode.cn id=51 lang=golang
 *
 * [51] N皇后
 */

// @lc code=start
func solveNQueens(n int) [][]string {
	var res = make([]int, n)
	var result [][]string
	dfsQueens(res, 0, n, &result)
	return result
}

// @lc code=end
func dfsQueens(res []int, row int, n int, result *[][]string) {
	if row >= n {
		// 已确认位置，加入数组
		print := printQueens(res, n)
		*result = append(*result, print)
		return
	}

	// 每一行都有 n 种放法
	for column := 0; column < n; column++ {
		// 判断是否满足要求
		if isOk(row, column, n, res) {
			// 第 row 行的棋子放到了 column 列
			res[row] = column
			// 考察下一行
			dfsQueens(res, row+1, n, result)
		}
	}
}

func isOk(row int, column int, n int, result []int) bool {
	leftUp, rightUp := column-1, column+1
	for i := row - 1; i >= 0; i-- { // 逐行往上考察每一行
		if result[i] == column { // 第 i 行的 column 列有棋子吗?
			return false
		}

		if leftUp >= 0 { // 考察左上对角线:第 i 行 leftUp 列有棋子吗?
			if result[i] == leftUp {
				return false
			}
		}

		if rightUp < n { // 考察右上对角线:第 i 行 rightUp 列有棋子吗?
			if result[i] == rightUp {
				return false
			}
		}
		leftUp--
		rightUp++
	}

	return true
}

func printQueens(result []int, n int) []string {
	s := []string{}
	for _, v := range result {
		str := ""
		for i := 0; i < n; i++ {
			if i == v {
				str += "Q"
			} else {
				str += "."
			}
		}
		s = append(s, str)
	}
	return s
}


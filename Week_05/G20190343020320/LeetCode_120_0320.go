package g20190343020320

// 120.三角形最小路径和
// https://leetcode-cn.com/problems/triangle/
func MinimumTotal(triangle [][]int) int {
	lt := len(triangle)
	arr := triangle[lt-1]
	for i := lt - 2; i >= 0; i-- {
		for j := 0; j < len(triangle[i]); j++ {
			arr[j] = triangle[i][j] + intMin(arr[j], arr[j+1])
		}
	}
	return arr[0]
}

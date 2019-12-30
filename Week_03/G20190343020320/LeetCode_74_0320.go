package g20190343020320

// 74.搜索二维矩阵
// https://leetcode-cn.com/problems/search-a-2d-matrix/

func SearchMatrix(matrix [][]int, target int) bool {

	if len(matrix) == 0 {
		return false
	}

	left, right := 0, len(matrix)-1
	findi, findj := -1, -1
	for left < right {
		mid := (left + right) / 2
		if matrix[mid][0] > target {
			right = mid - 1
		} else if matrix[mid][len(matrix[mid])-1] < target {
			left = mid + 1
		} else {
			findi = mid
			break
		}
	}

	if left == right {
		findi = left
	}

	if findi == -1 || len(matrix[findi]) == 0 {
		return false
	}

	left, right = 0, len(matrix[findi])-1
	for left < right {
		mid := (left + right) / 2
		if matrix[findi][mid] == target {
			findj = mid
			break
		}
		if matrix[findi][mid] < target {
			left = mid + 1
		} else {
			right = mid
		}
	}

	if left == right {
		findj = left
	}

	return findj != -1 && matrix[findi][findj] == target
}

// 移动查找法
func SearchMatrix2(matrix [][]int, target int) bool {
	if len(matrix) == 0 {
		return false
	}

	y, x := len(matrix[0])-1, 0

	for y > -1 && x < len(matrix) {
		if matrix[x][y] == target {
			return true
		} else if matrix[x][y] > target {
			y--
		} else {
			x++
		}
	}

	return false
}

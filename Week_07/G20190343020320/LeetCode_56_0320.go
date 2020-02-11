package g20190343020320

// 56.合并区间
// https://leetcode-cn.com/problems/merge-intervals/

func Merge_56(intervals [][]int) [][]int {
	MergeSort_56(intervals, 0, len(intervals)-1)
	count := 0
	for k := 1; k < len(intervals); k++ {
		if intervals[k-1][1] >= intervals[k][0] {
			intervals[k][0], intervals[k][1] = intervals[k-1][0], MaxInts(intervals[k-1][1], intervals[k][1])
			intervals[k-1], intervals[count] = intervals[count], intervals[k-1]
			count++
		}
	}
	return intervals[count:]
}

func MergeSort_56(intervals [][]int, left, right int) {
	if left >= right {
		return
	}

	mid := (left + right) >> 1
	MergeSort_56(intervals, left, mid)
	MergeSort_56(intervals, mid+1, right)
	SortM_56(intervals, left, mid, right)
}

func SortM_56(intervals [][]int, left, mid, right int) {
	temp := make([][]int, right-left+1)

	i, j := left, mid+1
	for idx := 0; idx < len(temp); idx++ {
		if j > right || (i <= mid && intervals[i][0] < intervals[j][0]) {
			temp[idx] = intervals[i]
			i++
		} else {
			temp[idx] = intervals[j]
			j++
		}
	}

	for p := 0; p < len(temp); p++ {
		intervals[left+p] = temp[p]
	}
}

func MaxInts(a, b int) int {
	if a > b {
		return a
	}
	return b
}

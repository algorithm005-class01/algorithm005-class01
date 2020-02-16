package g20190343020320

import "sort"

// 1122.数组的相对排序
// https://leetcode-cn.com/problems/relative-sort-array/

// 方法1:用 maps 记录顺序，实现归并排序
func RelativeSortArray_1(arr1 []int, arr2 []int) []int {
	maps := make(map[int]int)
	for i := 0; i < len(arr2); i++ {
		maps[arr2[i]] = i
	}

	MergeSort(arr1, maps, 0, len(arr1)-1)
	return arr1
}

func MergeSort(arr []int, maps map[int]int, left, right int) {
	if left >= right {
		return
	}

	mid := (left + right) >> 1
	MergeSort(arr, maps, left, mid)
	MergeSort(arr, maps, mid+1, right)

	Merge(arr, maps, left, mid, right)
}

func Merge(arr []int, maps map[int]int, left, mid, right int) {
	temp := make([]int, right-left+1)
	i, j, k := left, mid+1, 0
	for ; i <= mid && j <= right; k++ {
		a, ai := maps[arr[i]]
		b, bi := maps[arr[j]]

		if (!ai && !bi && arr[i] < arr[j]) || (!bi && ai) || (ai && bi && a < b) {
			temp[k] = arr[i]
			i++
		} else {
			temp[k] = arr[j]
			j++
		}
	}

	for ; i <= mid; i, k = i+1, k+1 {
		temp[k] = arr[i]
	}
	for ; j <= right; j, k = j+1, k+1 {
		temp[k] = arr[j]
	}

	for p := 0; p < len(temp); p++ {
		arr[left+p] = temp[p]
	}
}

// 方法2，桶排序
func RelativeSortArray_2(arr1 []int, arr2 []int) []int {
	maps := make(map[int]int)

	for _, v := range arr1 {
		maps[v]++
	}

	idx := 0
	for _, v := range arr2 {
		for maps[v] > 0 {
			arr1[idx] = v
			maps[v]--
			idx++
		}
		delete(maps, v)
	}

	start := idx
	for k, v := range maps {
		for v > 0 {
			arr1[idx] = k
			v--
			idx++
		}
	}

	sort.Ints(arr1[start:])
	return arr1
}

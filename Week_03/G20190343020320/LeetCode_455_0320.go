package g20190343020320

import "sort"

// 455.分发饼干
func FindContentChildren(g []int, s []int) int {

	if len(g) == 0 || len(s) == 0 {
		return 0
	}

	sort.Ints(g)
	sort.Ints(s)

	i := 0

	for _, v := range s {
		if v >= g[i] {
			i++
			if i == len(g) {
				break
			}
		}
	}

	return i
}

// 代码优化
func FindContentChildren2(g, s []int) int {
	if len(g) == 0 || len(s) == 0 {
		return 0
	}
	sort.Ints(g)
	sort.Ints(s)
	i, j := 0, 0
	for ; i < len(g) && j < len(s); j++ {
		if s[j] >= g[i] {
			i++
		}
	}
	return i
}

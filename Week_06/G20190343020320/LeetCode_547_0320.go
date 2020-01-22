package g20190343020320

// 547.并查集
// https://leetcode-cn.com/problems/friend-circles/
func FindCircleNum(M [][]int) int {
	b := UnionFindInit(len(M))

	for i := 0; i < len(M); i++ {
		for j := i + 1; j < len(M); j++ {
			if M[i][j] == 1 {
				b.union(i, j)
			}
		}
	}

	return b.Count
}

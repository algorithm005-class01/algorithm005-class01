package g20190343020320

// 构建并查集
type UnionFind struct {
	Parent []int
	Count  int
}

func UnionFindInit(k int) *UnionFind {
	p := make([]int, k)
	for i := 0; i < k; i++ {
		p[i] = i
	}

	return &UnionFind{
		Parent: p,
		Count:  k,
	}
}

func (b *UnionFind) find(k int) int {
	root := k
	for root != b.Parent[root] {
		root = b.Parent[root]
	}

	// 压缩路径
	for k != b.Parent[k] {
		k, b.Parent[k] = b.Parent[k], root
	}

	return k
}

func (b *UnionFind) union(p, q int) {
	rootP, rootQ := b.find(p), b.find(q)
	if rootP == rootQ {
		return
	}
	b.Parent[rootQ] = rootP
	b.Count--
}

// 二维数组并查集
type UnionFind2 struct {
	Parent [][][2]int
	Count  int
}

func UnionFindInit2(a, b int) *UnionFind2 {
	p := make([][][2]int, a)
	for i := 0; i < a; i++ {
		p[i] = make([][2]int, b)
		for j := 0; j < b; j++ {
			p[i][j] = [2]int{i, j}
		}
	}

	return &UnionFind2{
		Parent: p,
		Count:  a * b,
	}
}

func (b *UnionFind2) find2(i, j int) [2]int {
	rooti, rootj := i, j
	for [2]int{rooti, rootj} != b.Parent[rooti][rootj] {
		rooti, rootj = b.Parent[rooti][rootj][0], b.Parent[rooti][rootj][1]
	}

	// 压缩路径
	for [2]int{i, j} != b.Parent[i][j] {
		i, j, b.Parent[i][j] = b.Parent[i][j][0], b.Parent[i][j][1], [2]int{rooti, rootj}
	}

	return [2]int{i, j}
}

func (b *UnionFind2) union2(i, j, p, q int) {
	rootP, rootQ := b.find2(i, j), b.find2(p, q)
	if rootP == rootQ {
		return
	}
	b.Parent[rootQ[0]][rootQ[1]] = rootP
	b.Count--
}

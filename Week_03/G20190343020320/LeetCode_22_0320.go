package g20190343020320

// 22.括号生成
//

// DFS
func GenerateParenthesis(n int) []string {
	re22 = []string{}
	dfs22(n, 0, 0, "")
	return re22
}

var re22 []string

func dfs22(n, l, r int, s string) {
	if l < n {
		dfs22(n, l+1, r, s+"(")
	}

	if r < l {
		dfs22(n, l, r+1, s+")")
	}

	if l+r == 2*n {
		re22 = append(re22, s)
	}
}

// BFS
// 随堂练习
type node22 struct {
	val  string
	l, r int
}

func GenerateParenthesis2(n int) (re []string) {
	queue := []*node22{&node22{"(", 1, 0}}

	for len(queue) > 0 {
		q := queue[0]

		if q.l+q.r == 2*n {
			re = append(re, q.val)
		} else {
			if q.l < n {
				queue = append(queue, &node22{q.val + "(", q.l + 1, q.r})
			}
			if q.r < q.l {
				queue = append(queue, &node22{q.val + ")", q.l, q.r + 1})
			}
		}

		queue = queue[1:]
	}

	return
}

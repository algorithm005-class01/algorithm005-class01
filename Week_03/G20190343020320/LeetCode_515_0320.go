package g20190343020320

// 515.在每个树行中找最大值
// https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/

// BFS
func LargestValues(root *TreeNode) (re []int) {
	if root == nil {
		return
	}

	queue := []*TreeNode{root, nil}
	max := root.Val

	for len(queue) > 1 {
		p := queue[0]
		if p == nil {
			re = append(re, max)
			max = queue[1].Val
			queue = append(queue, nil)
		} else {
			if p.Val > max {
				max = p.Val
			}
			if p.Left != nil {
				queue = append(queue, p.Left)
			}
			if p.Right != nil {
				queue = append(queue, p.Right)
			}
		}

		queue = queue[1:]
	}

	return append(re, max)
}

// DFS
func LargestValues2(root *TreeNode) []int {
	re515 = make([]int, 0)
	if root != nil {
		largestDfs(root, 0)
	}
	return re515
}

var re515 []int

func largestDfs(point *TreeNode, deep int) {
	if len(re515) == deep {
		re515 = append(re515, point.Val)
	}

	if re515[deep] < point.Val {
		re515[deep] = point.Val
	}

	if point.Left != nil {
		largestDfs(point.Left, deep+1)
	}
	if point.Right != nil {
		largestDfs(point.Right, deep+1)
	}
}

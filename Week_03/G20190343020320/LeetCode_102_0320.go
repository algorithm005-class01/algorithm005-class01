package g20190343020320

// 102.二叉树层次遍历
// https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
func LevelOrder(root *TreeNode) [][]int {
	if root == nil {
		return [][]int{}
	}
	re := [][]int{[]int{}}
	queue := []*TreeNode{root, nil}
	i := 0

	for len(queue) > 1 {
		// 循环条件
		r := queue[0]
		if r == nil {
			re = append(re, []int{})
			queue = append(queue, nil)[1:]
			i++
			continue
		}

		// 读取数据
		re[i] = append(re[i], r.Val)

		// 下个循环变量
		if r.Left != nil {
			queue = append(queue, r.Left)
		}
		if r.Right != nil {
			queue = append(queue, r.Right)
		}

		// 清理全局变量
		queue = queue[1:]
	}

	return re
}

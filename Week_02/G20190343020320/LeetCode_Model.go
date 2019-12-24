package g20190343020320

// 放置 LeetCode 默认数据结构文件
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// 多叉树
type NTreeNode struct {
	Val      int
	Children []*NTreeNode
}

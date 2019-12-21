package main

func climbStairs(n int) int {
	var pree,pre int
	for i:=1;i<=n;i++{
		if i == 1 {
			pree,pre = 0,1
			continue
		}
		pree,pre = pre,pree+pre
	}

	return pre+pree
}
package main

import (
	"fmt"
	"testing"

	"github.com/stretchr/testify/assert"
)

type question struct {
	param
	ans
}

// param 是参数
// one 代表第一个参数
type param struct {
	nums []int
}

// ans 是答案
// one 代表第一个答案
type ans struct {
	one []int
}

func Test_Problem0283(t *testing.T) {
	ast := assert.New(t)

	qs := []question{
		question{
			param{[]int{0, 0, 1, 0, 3, 4}},
			ans{[]int{1, 3, 4, 0, 0, 0}},
		},
		question{
			param{[]int{0, 1, 0, 3, 12}},
			ans{[]int{1, 3, 12, 0, 0}},
		},
	}

	for _, q := range qs {
		a, p := q.ans, q.param
		fmt.Printf("--%v--\n", p)
		moveZeroes(p.nums)
		ast.Equal(a.one, p.nums, "输入:%v", p)
	}
}


package main

import (
	"fmt"
)

func main() {
	fmt.Println(isAnagram("anagram", "nagaram"))
}

/*
 * @lc app=leetcode.cn id=242 lang=golang
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	// 就是创建一个数组，一共26个格子，对应26个字母。如果s有就在那个位置+1，t就-1
	m := make([]int, 26)
	for i := 0; i < len(s); i++ {
		m[s[i]-'a']++
	}
	for i := 0; i < len(s); i++ {
		m[t[i]-'a']--
		if m[t[i]-'a'] < 0 {
			return false
		}
	}
	return true
}

// @lc code=end


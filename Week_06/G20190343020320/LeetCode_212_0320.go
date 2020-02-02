package g20190343020320

// 212.单词搜索2
//https://leetcode-cn.com/problems/word-search-ii/

func FindWords(board [][]byte, words []string) []string {

	all = []string{}
	if len(board) == 0 || len(words) == 0 {
		return all
	}

	trie := Constructor()
	for _, v := range words {
		trie.Insert(v)
	}

	cache := make([][]bool, len(board))
	for i := 0; i < len(board); i++ {
		cache[i] = make([]bool, len(board[i]))
	}

	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[i]); j++ {
			dfsHelper(board, cache, string(board[i][j]), &trie, i, j)
		}
	}

	return removeRepByMap(all)
}

var iAxis = []int{-1, 0, 1, 0}
var jAxis = []int{0, -1, 0, 1}
var all = []string{}

func dfsHelper(board [][]byte, cache [][]bool, re string, trie *Trie, i, j int) {
	if trie == nil {
		return
	}

	if v, ok := trie.Node[board[i][j]]; ok && !cache[i][j] {

		cache[i][j] = true

		if v.isWord {
			// 保存
			all = append(all, re)
		}

		for f := 0; f < 4; f++ {
			newi, newj := i+iAxis[f], j+jAxis[f]
			if newi > -1 && newi < len(board) && newj > -1 && newj < len(board[i]) {
				// next
				dfsHelper(board, cache, re+string(board[newi][newj]), v, newi, newj)
			}
		}

		cache[i][j] = false
	}
}

// 去重方法
func removeRepByMap(slc []string) []string {
	result := []string{}
	tempMap := map[string]byte{} // 存放不重复主键
	for _, e := range slc {
		l := len(tempMap)
		tempMap[e] = 0
		if len(tempMap) != l { // 加入map后，map长度变化，则元素不重复
			result = append(result, e)
		}
	}
	return result
}

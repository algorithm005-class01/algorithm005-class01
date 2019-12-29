package g20190343020320

// 127.单词接龙
// https://leetcode-cn.com/problems/word-ladder/
func LadderLength(beginWord string, endWord string, wordList []string) int {
	key := false
	for _, v := range wordList {
		if endWord == v {
			key = true
		}
	}

	if !key {
		return 0
	}

	visit := make([]bool, len(wordList))
	queue := []string{beginWord, ""}
	step := 1

	for len(queue) > 1 {
		b := queue[0]
		if b == "" {
			step++
			queue = append(queue, "")
		} else {
			for k, v := range wordList {
				if visit[k] {
					continue
				}
				if validLadder127(b, v) == 1 {
					if validLadder127(v, endWord) == 0 {
						return step + 1
					}

					visit[k] = true
					queue = append(queue, v)
				}
			}
		}
		queue = queue[1:]
	}

	return 0
}

func validLadder127(a, b string) (r int) {
	for k, v := range b {
		if v != rune(a[k]) {
			if r++; r > 1 {
				return
			}
		}
	}
	return
}

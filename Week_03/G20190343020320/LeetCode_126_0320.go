package g20190343020320

// 126.单词接龙2
// https://leetcode-cn.com/problems/word-ladder-ii/

// 超时解
func FindLadders(beginWord string, endWord string, wordList []string) [][]string {
	re := [][]string{}
	key := false

	for _, v := range wordList {
		if v == endWord {
			key = true
		}
	}

	if !key {
		return re
	}

	queue := [][]string{[]string{beginWord}, nil}
	visit := make([]bool, len(wordList))
	var visitCache []bool

	for len(queue) > 1 {
		q := queue[0]

		if q == nil {
			if len(re) > 0 {
				break
			}
			queue = append(queue, nil)
		} else {
			for k, v := range wordList {
				if visit[k] {
					continue
				}

				visitCache = make([]bool, len(wordList))
				// visitCache = 0

				if validLadder126(q[len(q)-1], v) == 1 {
					cache := []string{}
					if validLadder126(v, endWord) == 0 {
						re = append(re, append(append(cache, q...), endWord))
						continue
					}

					// visit[k] = true
					visitCache[k] = true
					// visit |= 1 << uint(k)
					// visitCache |= 1 << uint(k)
					queue = append(queue, append(append(cache, q...), v))
				}
			}
			// visit |= visitCache
			for k, v := range visitCache {
				if v {
					visit[k] = true
				}
			}
		}

		queue = queue[1:]
	}

	return re
}

func validLadder126(strA, strB string) (reVal int) {
	for k, runeA := range strA {
		if runeA == rune(strB[k]) {
			if reVal++; reVal > 1 {
				return
			}
		}
	}

	return
}

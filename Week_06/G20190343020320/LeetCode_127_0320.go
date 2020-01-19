package g20190343020320

// 127.单词接龙
// https://leetcode-cn.com/problems/word-ladder/

// 双向BFS
func LadderLength(beginWord string, endWord string, wordList []string) int {

	if len(beginWord) == 0 || len(beginWord) != len(endWord) || len(wordList) == 0 {
		return 0
	}

	wordMaps := make(map[string]bool)
	beginLevel, endLevel := map[string]bool{beginWord: true}, map[string]bool{endWord: true}

	for _, v := range wordList {
		wordMaps[v] = true
	}

	count := 1
	if _, ok := wordMaps[endWord]; !ok {
		return 0
	}

	for len(beginLevel) != 0 && len(endLevel) != 0 {

		count++
		cacheQueue := map[string]bool{}
		for k, _ := range beginLevel {

			for i := 0; i < len(k); i++ {
				newWordRune := []rune(k)
				for j := 'a'; j < 'z'; j++ {
					newWordRune[i] = j
					newWord := string(newWordRune)

					if _, ok := endLevel[newWord]; ok {
						return count
					}

					if _, ok := wordMaps[newWord]; ok {
						delete(wordMaps, newWord)
						cacheQueue[newWord] = true
					}
				}
			}
		}

		beginLevel = cacheQueue

		if len(beginLevel) > len(endLevel) {
			beginLevel, endLevel = endLevel, beginLevel
		}
	}

	return 0
}

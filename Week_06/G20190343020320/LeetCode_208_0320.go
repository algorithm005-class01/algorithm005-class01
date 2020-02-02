package g20190343020320

// 208.实现Tire（前缀树）
// https://leetcode-cn.com/problems/implement-trie-prefix-tree/

type Trie struct {
	Node   map[byte]*Trie
	isWord bool
}

/** Initialize your data structure here. */
func Constructor() Trie {
	return Trie{
		Node: make(map[byte]*Trie),
	}
}

/** Inserts a word into the trie. */
func (this *Trie) Insert(word string) {
	searchTrie := this
	for i := 0; i < len(word); i++ {
		if v, ok := searchTrie.Node[word[i]]; ok {
			searchTrie = v
		} else {
			searchTrie.Node[word[i]] = &Trie{
				Node: make(map[byte]*Trie),
			}
			searchTrie = searchTrie.Node[word[i]]
		}
	}
	searchTrie.isWord = true
}

/**	递归
	func (this *Trie) Insert(word string) {
		if len(word) == 0 {
			this.isWord = true
			return
		}

		if v, ok := this.Node[word[0]]; ok {
			v.Insert(word[1:])
		} else {
			this.Node[word[0]] = &Trie{
				Node: make(map[byte]*Trie),
			}

			this.Node[word[0]].Insert(word[1:])
		}
	}
**/

/** Returns if the word is in the trie. */
func (this *Trie) Search(word string) bool {
	searchTrie := this.stringPrefix(word)
	return searchTrie != nil && searchTrie.isWord
}

/** Returns if there is any word in the trie that starts with the given prefix. */
func (this *Trie) StartsWith(prefix string) bool {
	return this.stringPrefix(prefix) != nil
}

func (this *Trie) stringPrefix(prefix string) *Trie {
	searchTrie := this
	for i := 0; i < len(prefix); i++ {
		if v, ok := searchTrie.Node[prefix[i]]; ok {
			searchTrie = v
		} else {
			return nil
		}
	}
	return searchTrie
}

/** 递归
	func (this *Trie) stringPrefix(prefix string) *Trie {
		if len(prefix) == 0 {
			return this
		}

		if v, ok := this.Node[prefix[0]]; ok {
			return v.stringPrefix(prefix[1:])
		}
		return nil
	}
**/

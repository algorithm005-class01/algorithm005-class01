package main.leetcode_solutions.tree;

/**
 * @author wenzhuang
 * @date 2020/1/19
 */
public class T208_ImplementTriePrefixTree {
    class Trie {
        Trie[] children = new Trie[26];
        boolean isEndOfWord;

        /**
         * Initialize your data structure here.
         */
        public Trie() {

        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Trie trie = this;
            for (int i = 0; i < word.length(); i++) {
                if (trie.children[word.charAt(i) - 'a'] == null) {
                    trie.children[word.charAt(i) - 'a'] = new Trie();
                }
                trie = trie.children[word.charAt(i) - 'a'];
            }
            trie.isEndOfWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Trie trie = this;
            for (int i = 0; i < word.length(); i++) {
                trie = trie.children[word.charAt(i) - 'a'];
                if (trie == null) {
                    return false;
                }
            }
            return trie.isEndOfWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Trie trie = this;
            for (int i = 0; i < prefix.length(); i++) {
                trie = trie.children[prefix.charAt(i) - 'a'];
                if (trie == null) {
                    return false;
                }
            }
            return true;
        }
    }
}

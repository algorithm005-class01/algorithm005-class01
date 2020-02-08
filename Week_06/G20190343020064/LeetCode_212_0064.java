package G20190343020064;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * <p>
 * 单词搜索 II
 * </p>
 *
 * @author mingke.yan@hand-china.com 2020-01-26 5:32 下午
 */
public class LeetCode_212_0064 {

    public List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        Trie tire = new Trie();
        for (String word : words) {
            tire.insert(word);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                this.findWord("",board,i,j,tire);
            }
        }
        result.sort(Comparator.comparing(String::toString));
        return result;
    }

    public void findWord(String word, char[][] board, int i, int j, Trie tire) {
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] == '#') {
            return;
        }
        char ch = board[i][j];
        String str = word + ch;
        board[i][j] = '#';
        if (tire.startsWith(str)) {
            if (tire.search(str) && !result.contains(str)) {
                result.add(str);
            }
            findWord(str, board, i + 1, j, tire);
            findWord(str, board, i - 1, j, tire);
            findWord(str, board, i, j + 1, tire);
            findWord(str, board, i, j - 1, tire);
        }
        board[i][j] = ch;
    }

    class Trie {

        private TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode temp = root;
            for (int i = 0; i < word.length(); i++) {
                char curChar = word.charAt(i);
                if (temp.contains(curChar)) {
                    temp = temp.get(curChar);
                } else {
                    temp = temp.insert(curChar);
                }
            }
            temp.setEnd();
        }

        public TrieNode searchPrefix(String word) {
            TrieNode temp = root;
            for (int i = 0; i < word.length(); i++) {
                char curChar = word.charAt(i);
                if (temp.contains(curChar)) {
                    temp = temp.get(curChar);
                } else {
                    return null;
                }
            }
            return temp;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode trieNode = this.searchPrefix(word);
            return trieNode == null ? false : trieNode.isEnd();
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode trieNode = this.searchPrefix(prefix);
            return trieNode != null;
        }

        class TrieNode {

            private TrieNode[] child;

            private final int NUM = 26;

            private boolean endFlag = false;

            public TrieNode() {
                child = new TrieNode[NUM];
            }

            private boolean contains(char ch) {
                return child[ch - 'a'] != null;
            }

            private TrieNode get(char ch) {
                return child[ch - 'a'];
            }

            private TrieNode insert(char ch) {
                child[ch - 'a'] = new TrieNode();
                return child[ch - 'a'];
            }

            private void setEnd() {
                this.endFlag = true;
            }

            private boolean isEnd() {
                return this.endFlag;
            }
        }
    }

}

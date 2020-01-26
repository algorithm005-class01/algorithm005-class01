package G20190343020064;

import org.junit.Test;

import java.util.Timer;

/**
 * <p>
 * 实现 Trie (前缀树)
 * </p>
 *
 * @author mingke.yan@hand-china.com 2020-01-26 11:55 上午
 */
public class LeetCode_208_0064 {

    class Trie {

        private TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode temp = root;
            for(int i = 0; i < word.length(); i++) {
                if (temp.contains(word.charAt(i))) {
                    temp = temp.get(word.charAt(i));
                } else {
                    temp = temp.insert(word.charAt(i));
                }
            }
            temp.setEnd();
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode temp = root;
            for(int i = 0; i < word.length(); i++) {
                if (temp == null) {return false;}
                if (temp.contains(word.charAt(i))) {
                    temp = temp.get(word.charAt(i));
                } else {
                    temp = null;
                }
            }
            return temp == null ? false : temp.isEnd();
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode temp = root;
            for(int i = 0; i < prefix.length(); i++) {
                if (temp == null) {
                    return false;
                }
                if (temp.contains(prefix.charAt(i))) {
                    temp = temp.get(prefix.charAt(i));
                } else {
                    return false;
                }
            }
            return temp != null;

        }
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

        private TrieNode get(char ch){
            return child[ch - 'a'];
        }

        private TrieNode insert(char ch) {
            child[ch - 'a'] = new TrieNode();
            return child[ch - 'a'];
        }

        private void setEnd(){
            this.endFlag = true;
        }

        private boolean isEnd() {
            return this.endFlag;
        }
    }

}

package com.miui.testbyxzl;

/**
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * <p>
 * 示例:
 * <p>
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 * <p>
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCodde_208_0010 {

    class Trie {


        public class TrieNode {
            private TrieNode nodes[];

            public TrieNode() {
                nodes = new TrieNode[26];
            }

            public TrieNode get(char ch) {
                return nodes[ch - 'a'];
            }

            public void put(char ch, TrieNode node) {
                nodes[ch - 'a'] = node;
            }

            public boolean containKey(char ch) {
                return nodes[ch - 'a'] != null;
            }

            private boolean mIsEnd;

            public void setEnd() {
                mIsEnd = true;
            }

            public boolean isEnd() {
                return mIsEnd;
            }

        }

        private TrieNode trieNode;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            trieNode = new TrieNode();
        }

        public TrieNode searchWord(String word) {
            TrieNode node = trieNode;
            for (int i = 0; i < word.length(); i++) {
                char subChar = word.charAt(i);
                if (node.containKey(subChar)) {
                    node = node.get(subChar);
                } else {
                    return null;
                }
            }

            return node;
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode node = trieNode;
            for (int i = 0; i < word.length(); i++) {
                char subChar = word.charAt(i);

                if (!node.containKey(subChar)) {
                    node.put(subChar, new TrieNode());
                }
                node = node.get(subChar);
            }

            node.setEnd();
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode trieNode = searchWord(word);
            return trieNode != null && trieNode.isEnd();
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode trieNode = searchWord(prefix);
            return trieNode != null;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}

//给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。 
//
// 示例: 
//
// 输入: 
//words = ["oath","pea","eat","rain"] and board =
//[
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//
//输出: ["eat","oath"] 
//
// 说明: 
//你可以假设所有输入都由小写字母 a-z 组成。 
//
// 提示: 
//
// 
// 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？ 
// 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。 
// 
// Related Topics 字典树 回溯算法

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchIi {
    public static void main(String[] args) {
        Solution solution = new WordSearchIi().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<String> result = new HashSet<>();
        boolean[][] visited;

        public List<String> findWords(char[][] board, String[] words) {

            Trie trie = new Trie();
            for (String word : words) {
                trie.insert(word);
            }
            int m = board.length;
            int n = board[0].length;
            visited = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dfs(board, i, j, m, n, trie);
                }


            }


            return new ArrayList<>(result);
        }

        private void dfs(char[][] board, int i, int j, int m, int n, Trie trie) {
            char c = board[i][j];
            trie.startsWith(c + "");
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
                TrieNode node = root;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (!node.containsKey(c)) {
                        node.put(c, new TrieNode());
                    }
                    node = node.get(c);
                }
                node.setEnd();
            }

            private TrieNode searchPrefix(String word) {
                TrieNode node = root;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (node.containsKey(c)) {
                        node = node.get(c);
                    } else {
                        return null;
                    }
                }
                return node;

            }

            /**
             * Returns if the word is in the trie.
             */
            public boolean search(String word) {
                TrieNode node = searchPrefix(word);
                return node != null && node.isEnd();
            }

            /**
             * Returns if there is any word in the trie that starts with the given prefix.
             */
            public boolean startsWith(String prefix) {
                return searchPrefix(prefix) != null;
            }

            class TrieNode {
                private final int R = 26;
                private TrieNode[] links;
                private boolean isEnd;

                public TrieNode() {
                    links = new TrieNode[R];
                }

                public boolean containsKey(char ch) {
                    return links[ch - 'a'] != null;
                }

                public TrieNode get(char ch) {
                    return links[ch - 'a'];
                }

                public void put(char ch, TrieNode node) {
                    links[ch - 'a'] = node;
                }

                public void setEnd() {
                    isEnd = true;
                }

                public boolean isEnd() {
                    return isEnd;
                }

            }
        }
//leetcode submit region end(Prohibit modification and deletion)


    }
}
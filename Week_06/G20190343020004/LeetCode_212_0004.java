package com.zyh.test.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LeetCode_212_0004 {

    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length < 1 || board[0].length < 1) {
            //应该返回null，但LeetCode要求返回[]
            return new ArrayList<>(0);
        }
        if (words == null || words.length < 1) {
            return new ArrayList<>(0);
        }
        HashSet<String> result = new HashSet<>();

        //构建Trie
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                Trie.TrieNode rootNode = trie.getRootNode();
                if (rootNode.get(board[i][j]) != null) {
                    dfs(board, i, j, "", rootNode, result);
                }
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, int i, int j, String word, Trie.TrieNode trieNode, HashSet<String> result) {
        word += board[i][j];
        trieNode = trieNode.get(board[i][j]);
        if (trieNode.isEnd()) {
            result.add(word);
        }
        char temp = board[i][j];
        board[i][j] = '@';
        for (int k = 0; k < dx.length; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x > -1 && x < board.length && y > -1 && y < board[x].length) {
                if (board[x][y] != '@' && trieNode.get(board[x][y]) != null) {
                    dfs(board, x, y, word, trieNode, result);
                }
            }
        }
        board[i][j] = temp;
    }

    static class Trie {

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
                char currentChar = word.charAt(i);
                if (!node.containsKey(currentChar)) {
                    node.put(currentChar, new TrieNode());
                }
                node = node.get(currentChar);
            }
            node.setEnd();
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
            TrieNode node = searchPrefix(prefix);
            return node != null;
        }

        public TrieNode getRootNode() {
            return root;
        }

        public TrieNode searchPrefix(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                if (node.containsKey(currentChar)) {
                    node = node.get(currentChar);
                } else {
                    return null;
                }
            }
            return node;
        }

        static class TrieNode {

            private TrieNode[] links;
            private final int R = 26;
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
}

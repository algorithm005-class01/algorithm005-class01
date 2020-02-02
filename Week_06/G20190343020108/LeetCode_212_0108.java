import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    Set<String> res = new HashSet<String>();

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word : words)
            trie.insert(word);

        int m = board.length;
        int n = board[0].length;
        boolean [][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++) {
                dfs(board, visited, "", i, j, trie);
            }

        return new ArrayList<String>(res);
    }

    public void dfs(char[][] board, boolean[][] visited, String str, int x, int y, Trie trie) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return;
        if(visited[x][y]) return;

        str += board[x][y];
        if(!trie.startsWith(str)) return;
        if(trie.search(str)) res.add(str);

        visited[x][y] = true;
        dfs(board, visited, str, x - 1, y, trie);
        dfs(board, visited, str, x + 1, y, trie);
        dfs(board, visited, str, x, y - 1, trie);
        dfs(board, visited, str, x, y + 1, trie);
        visited[x][y] = false;
    }

    /* Definition for Trie */    
    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord;
        public TrieNode () {}
    }

    public class Trie {
        private TrieNode root;
        public Trie () {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(node != null && node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }

        public boolean search(String word) {
            TrieNode node = searchHelper(word);
            return node != null && node.isWord;
        }

        public boolean startsWith(String word) {
            TrieNode node = searchHelper(word);
            return node != null;
        }

        // search word or prefix
        private TrieNode searchHelper(String str) {
            TrieNode node = root;
            for(int i = 0; i < str.length() && node != null; i++) {
                char c = str.charAt(i);
                node = node.children[c - 'a'];
            }
            return node;
        }
    }
}
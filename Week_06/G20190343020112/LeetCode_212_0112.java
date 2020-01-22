// 这是写的第一版，性能并不高，关键优化点在于前缀树的查询部分，应当避免每次从矩阵里组成一个新单词时就从前缀树查询，前缀的树查询部分也应当考虑回溯
class Solution {

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int m = board == null ? 0 : board.length, n = m > 0 ? board[0].length : 0;
        List<String> res = new ArrayList<>();
        Set<String> existed = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0;j < n; j++) {
                backtrack("", i, j, m - 1, n - 1, board, trie, new boolean[m][n], res, existed);
            }
        }

        return res;
    }

    private void backtrack(String word, int i, int j, int m, int n, char[][] board, Trie trie, boolean[][] visited, List<String> res, Set<String> existed) {
        if (i < 0 || j < 0 || i > m || j > n || visited[i][j]) return;
        String w = word + board[i][j];
        if (trie.search(w) && !existed.contains(w)) {
            res.add(w);
            existed.add(w);
        } 
        if (trie.startsWith(w)) {
            visited[i][j] = true;
            for (int d = 0; d < 4; d++) {
                backtrack(w, i + dx[d], j + dy[d], m, n, board, trie, visited, res, existed);
            }
            visited[i][j] = false;
        } 
    }

    class Trie {

        private Node root = new Node();

        /** Initialize your data structure here. */
        public Trie() {
            
        }
        
        /** Inserts a word into the trie. */
        public void insert(String word) {
            int length = word == null ? 0 : word.length();
            if (length == 0) return;

            Node node = root;
            for (int i = 0; i < length; i++) {
                node = node.containsKey(word.charAt(i)) ? node.get(word.charAt(i)) : node.put(word.charAt(i));
            }
            node.setEnd();
        }
        
        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Node node = searchPrefix(word);
            return node != null && node.isEnd();
        }
        
        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        private Node searchPrefix(String word) {
            int length = word == null ? 0 : word.length();
            Node node = root;
            for (int i = 0; i < length; i++) {
                if (node.containsKey(word.charAt(i))) node = node.get(word.charAt(i));
                else return null;
            }
            return node;
        }

        

        class Node {
            Node[] links = new Node[26];
            boolean isEnd = false;

            Node put(char c) {
                Node node = new Node();
                links[c - 'a'] = node;
                return node;
            }

            Node get(char c) {
                return links[c - 'a'];
            }

            boolean containsKey(char c) {
                return links[c - 'a'] != null;
            }

            void setEnd() {
                isEnd = true;
            }

            boolean isEnd() {
                return isEnd;
            }


        }
    }

}
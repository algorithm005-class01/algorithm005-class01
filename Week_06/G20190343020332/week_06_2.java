class Solution {

    private int m;
    private int n;
    private char[][] board;
    private String[] words;
    private boolean [][] visited;
    private Set<String> ans = new HashSet<>();
    private Trie trie = new Trie();
    private int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        if(board.length == 0)
            return new ArrayList<String>();
        n = board[0].length;
        visited = new boolean[m][n];
        this.board = board;
        this.words = words;
        for(String word : words){
            trie.insert(word);
        }

        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++){
                dfs(i, j, trie.root);
            }
        return new ArrayList(ans);
    }

    public void dfs(int x, int y, TrieNode node){
        node = node.links[board[x][y] - 'a'];
        if(node == null){
            return;
        }
        visited[x][y] = true;

        if(node.isEnd){
            ans.add(node.val);
        }

        for(int k = 0; k < 4; k++){
            int newx = x + directions[k][0];
            int newy = y + directions[k][1];
            if(isArea(newx, newy) && !visited[newx][newy])
                dfs(newx, newy, node);
        }
        visited[x][y] = false;
    }

    public boolean isArea(int x, int y){
        return (x >= 0 && x < m && y >= 0 && y < n);
    }
}

class Trie {

    public TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
        node.val = word;
    }
}

class TrieNode{
    public TrieNode[] links;
    private final int R = 26;
    public boolean isEnd;
    public String val;
    public TrieNode(){
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch){
        return links[ch - 'a'] != null;
    } 

    public TrieNode get(char ch){
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node){
        links[ch - 'a'] = node;
    }

    public boolean isEnd(){
        return isEnd;
    }

    public void setEnd(){
        isEnd = true;
    }
}
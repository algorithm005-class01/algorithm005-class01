class TrieNode {
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    public TrieNode() {}
}

class Trie {
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            if(node.children[curChar - 'a'] == null)
                node.children[curChar - 'a'] = new TrieNode();
            node = node.children[curChar - 'a'];
        }
        node.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchHelper(word);
        return node != null && node.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchHelper(prefix);
        return node != null;
    }

    /* seach a prefix or a whole key in the Trie */
    private TrieNode searchHelper(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length() && node != null; i++) {
            char curChar = word.charAt(i);
            node = node.children[curChar - 'a'];
        }
        return node;
    }
}
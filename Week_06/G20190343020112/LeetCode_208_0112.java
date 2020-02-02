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

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
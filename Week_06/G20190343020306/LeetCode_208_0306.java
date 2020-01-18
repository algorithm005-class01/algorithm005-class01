class Trie {
    private Trie[] charList;
    private boolean isEndOfWord;
    private static final int LENGTH = 26;

    /** Initialize your data structure here. */
    public Trie() {
        charList = new Trie[LENGTH];
        isEndOfWord = false;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public Trie[] getCharList() {
        return charList;
    }

    public void createNewNodeAtIndex(int i) {
        charList[i] = new Trie();
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node = this;
        for (char c: word.toCharArray()) {
            Trie nextNode = node.getCharList()[c - 'a'];
            if (nextNode == null) {
                node.createNewNodeAtIndex(c - 'a');
            }
            node = node.getCharList()[c - 'a'];
        }
        node.setEndOfWord(true);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = this;
        for (char c: word.toCharArray()) {
            Trie nextNode = node.charList[c - 'a'];
            if (nextNode != null) {
                node = nextNode;
            } else {
                return false;
            }
        }
        return node.isEndOfWord();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = this;
        for (char c: prefix.toCharArray()) {
            Trie nextNode = node.charList[c - 'a'];
            if (nextNode != null) {
                node = nextNode;
            } else {
                return false;
            }
        }
        return true;
    }
}
class Trie {

    private final int N = 26;

    private TreeNode root;

    class TreeNode {

        private boolean isEnd;

        private TreeNode[] children = new TreeNode[26];

        TreeNode(boolean isEnd) {
            this.isEnd = isEnd;
        }

    }

    /** Initialize your data structure here. */
    public Trie() {
        root = new TreeNode(false);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (cur.children[letter - 97] == null) {
                cur.children[letter - 97] = new TreeNode(false);
            }
            cur = cur.children[letter - 97];
        }
        cur.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (cur.children[letter - 97] == null) {
                return false;
            }
            cur = cur.children[letter - 97];
        }
        return cur.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char letter = prefix.charAt(i);
            if (cur.children[letter - 97] == null) {
                return false;
            }
            cur = cur.children[letter - 97];
        }
        return true;
    }
}
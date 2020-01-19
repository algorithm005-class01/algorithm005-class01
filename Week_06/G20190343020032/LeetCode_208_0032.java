class Trie {
    class TreeNode{
        char val;
        TreeNode[] next;
        TreeNode(char x) {
            val = x;
            next = new TreeNode[27];
        }
    }

    TreeNode head;

    /** Initialize your data structure here. */
    public Trie() {
        head = new TreeNode('0');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode p = head;
        for (char ch : word.toCharArray()) {
            if (p.next[ch-'a'] == null) {
                p.next[ch-'a'] = new TreeNode(ch);
            }
            p = p.next[ch-'a'];
        }
        p.next[26] = new TreeNode('0');
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode p = head;
        for (char ch : word.toCharArray()) {
            if (p.next[ch-'a'] == null)
                return false;
            if (p.next[ch-'a'].val != ch)
                return false;
            p = p.next[ch-'a'];
        }
        if (p.next[26] == null) // end point
            return false;
        else
            return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode p = head;
        for (char ch : prefix.toCharArray()) {
            if (p.next[ch-'a'] == null)
                return false;
            if (p.next[ch-'a'].val != ch)
                return false;
            p = p.next[ch-'a'];
        }
        return true;
    }
}
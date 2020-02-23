//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
//
// 示例:
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");
//trie.search("app");     // 返回 true
//
// 说明:
//
//
// 你可以假设所有的输入都是由小写字母 a-z 构成的。
// 保证所有输入均为非空字符串。
//
// Related Topics 设计 字典树


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Trie {

    private static final int SIZE = 26;

    private Trie[] nodeList;
    private boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        nodeList = new Trie[SIZE];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.containedKey(c)) {
                node.nodeList[c-'a'] = new Trie();
            }
            node = node.getNode(c);
        }
        node.setIsEnd(true);
    }

    private boolean containedKey (char c) {
        return getNode(c)!=null;
    }

    private Trie getNode (char c) {
        return nodeList[c-'a'];
    }


    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node!=null && node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node!=null;
    }

    private Trie searchPrefix (String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            node = node.getNode(c);
            if (node==null) {
                return node;
            }
        }
        return node;
    }

    private void setIsEnd (boolean isEnd) {
        this.isEnd = isEnd;
    }

    private boolean getIsEnd () {
        return isEnd;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

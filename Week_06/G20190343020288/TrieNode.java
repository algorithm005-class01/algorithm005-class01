package week_06.commit;


// 208. 实现 Trie (前缀树)
// https://leetcode-cn.com/problems/implement-trie-prefix-tree/
public class TrieNode {

    public char val;
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];

    public TrieNode() {
    }

    TrieNode(char c) {
        TrieNode node = new TrieNode();
        node.val = c;
    }
}

package com.demo.test.leetcode;

/**
 * TODO
 *实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。

 示例:

 Trie trie = new Trie();

 trie.insert("apple");
 trie.search("apple");   // 返回 true
 trie.search("app");     // 返回 false
 trie.startsWith("app"); // 返回 true
 trie.insert("app");
 trie.search("app");     // 返回 true
 说明:

 你可以假设所有的输入都是由小写字母 a-z 构成的。
 保证所有输入均为非空字符串。

 * @author houyujia
 * @since 2020/1/19
 */
public class implement_trie_prefixtree_208 {
    public static void main(String[] args) {
        Trie trie =new Trie();
        trie.insert("bee");
        Boolean flag = trie.search("e");
        Boolean flag1=trie.startsWith("b");
    }

    static class Trie {
        //定一个节点初始化及类型
        class TrieNode {
            public int path;
            public int end;
            public TrieNode[] map;
            public TrieNode() {
                path = 0;
                end = 0;
                map = new TrieNode[26];
            }
        }
        private TrieNode root;
        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }
        /** Inserts a word into the trie. */
        public void insert(String word) {
            if(word == null) {
                return;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            node.path++;
            int index = 0;
            for(int i=0;i<chs.length;i++) {
                index = chs[i] - 'a';
                if(node.map[index] == null) {
                    node.map[index] = new TrieNode();
                }
                node = node.map[index];
                node.path++;
            }

            node.end++;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            if(word == null) {
                return false;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for(int i=0;i<chs.length;i++) {
                index = chs[i] - 'a';
                if(node.map[index] == null) {
                    return false;
                }
                node = node.map[index];
            }
            return node.end !=0;
        }
        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            if(prefix == null) {
                return false;
            }
            char[] chs = prefix.toCharArray();
            TrieNode node = root;
            int index = 0;
            for(int i=0;i<chs.length;i++) {
                index = chs[i] - 'a';
                if(node.map[index] == null) {
                    return false;
                }
                node = node.map[index];
            }
            return true;
        }
    }

}

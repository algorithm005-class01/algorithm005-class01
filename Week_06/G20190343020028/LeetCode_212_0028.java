//给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。 
//
// 示例: 
//
// 输入: 
//words = ["oath","pea","eat","rain"] and board =
//[
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//
//输出: ["eat","oath"] 
//
// 说明: 
//你可以假设所有输入都由小写字母 a-z 组成。 
//
// 提示: 
//
// 
// 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？ 
// 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。 
// 
// Related Topics 字典树 回溯算法


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};

    class TrieNode {
        public String value;
        public TrieNode[] child = new TrieNode[26];
        public boolean isEnd;
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;

            for (int i = 0; i < word.length(); i++) {
                char currChar = word.charAt(i);
                if (node.child[currChar - 'a'] == null) {
                    node.child[currChar - 'a'] = new TrieNode();
                }
                node = node.child[currChar - 'a'];
            }

            node.value = word;
            node.isEnd = true;
        }
    }

    private static final char FLAG = '#';

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        List<String> res = new ArrayList<>();

        for (String word : words) {
            trie.insert(word);
        }

        int x = board.length;
        if (x == 0) {
            return res;
        }
        int y = board[0].length;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                find(board, i, j, trie.root, res);
            }
        }
        return res;
    }

    private void find(char[][] board, int x, int y, TrieNode node, List<String> res) {
        // 边界判断
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return;
        }

        char curr = board[x][y];
        // 已遍历过节点或前缀树中不存在的字符
        if (curr == FLAG || node.child[curr - 'a'] == null) {
            return;
        }

        node = node.child[curr - 'a'];

        if (node.value != null) {
            res.add(node.value);
            node.value = null;
        }

        char temp = board[x][y];
        board[x][y] = FLAG;

        for (int i = 0; i < 4; i++) {
            int childX = x + dx[i];
            int childY = y + dy[i];
            find(board, childX, childY, node, res);
        }
        // 回复原始矩阵状态
        board[x][y] = temp;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

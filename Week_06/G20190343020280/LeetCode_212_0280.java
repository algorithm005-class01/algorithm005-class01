//给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
//
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
// 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何
//实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
//
// Related Topics 字典树 回溯算法


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.insertWord(words[i]);
        }
        List<String> result = new ArrayList<String>();
        int row = board.length;
        if (row==0) {
            return result;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfsMatch(board, i, j, trie, result);
            }
        }
        return result;

    }

    private void dfsMatch (char[][] board, int row, int column, Trie trie, List<String> result) {
        //终止条件
        if (row<0 || column<0 || row>=board.length || column>=board[0].length) {
            return;
        }
        //剪枝
        if (board[row][column]=='#' || !trie.containKey(board[row][column])) {
            return;
        }
        trie = trie.getNode(board[row][column]);
        if (trie.word!=null) {
            result.add(trie.word);
            trie.word=null;
        }
        char temp = board[row][column];
        //标记已经访问节点
        board[row][column] = '#';
        dfsMatch(board, row+1, column, trie, result);
        dfsMatch(board, row, column+1, trie, result);
        dfsMatch(board, row-1, column, trie, result);
        dfsMatch(board, row, column-1, trie, result);
        board[row][column] = temp;
    }

    class Trie {
        private static final int SIZE = 26;
        public String word;
        private Trie[] nodeList;

        public Trie () {
            nodeList = new Trie[SIZE];
        }

        public void insertWord (String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!node.containKey(c)) {
                    node.nodeList[c-'a'] = new Trie();
                }
                node = node.getNode(c);
            }
            node.word = word;
        }

        public boolean searchWord (String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!node.containKey(c)) {
                    return false;
                }
                node = node.getNode(c);
            }
            return node!=null && node.word!=null;

        }

        private Trie getNode (char c) {
            return nodeList[c-'a'];
        }

        public boolean containKey (char c) {
            return getNode(c)!=null;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

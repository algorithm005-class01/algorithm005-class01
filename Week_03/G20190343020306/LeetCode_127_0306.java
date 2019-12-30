/**
LeetCode 127 Word Ladder
BFS广度优先遍历方法

其实有点像二叉树的层序遍历
但是children不是预先设定好的, 而是要计算出来
计算过程一定要剪枝, 否则必然超时
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        
        int length = bfs(beginWord, endWord, visited, wordSet);
        return length;
    }

    private int bfs(String beginWord, String endWord, Set<String> visited, Set<String> wordSet) {
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        visited.add(beginWord);

        int length = 0;
        int level = 1;
        while (!queue.isEmpty()) {
            List<String> nextLevel = new ArrayList<>();

            for (String s: queue) {
                visited.add(s);
                //每次替换s的一个字母
                for (int i = 0; i < s.length(); i++) {
                    for (char c = 'a'; c < 'z'; c++) {
                        if (c == s.charAt(i)) {
                            continue; //滤去自己
                        }
                        StringBuilder sb = new StringBuilder(s);
                        sb.replace(i, i + 1, String.valueOf(c));
                        String replacedWord = sb.toString();
                        if (replacedWord.equals(endWord)) {
                            return level + 1; //找到了直接返回当前层+1
                        }
                        if (!visited.contains(replacedWord) && wordSet.contains(replacedWord)) {
                            visited.add(replacedWord); //这里直接把word加到visited里面去, 否则后面可能会有重复计算的情况
                            nextLevel.add(replacedWord);
                        }
                    }
                }
            }
            queue.clear();
            queue.addAll(nextLevel);
            level ++;
        }

        return length;
    }
}
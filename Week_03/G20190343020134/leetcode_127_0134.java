package sort.day1;

//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
//
//
// 每次转换只能改变一个字母。
// 转换过程中的中间单词必须是字典中的单词。
//
//
// 说明:
//
//
// 如果不存在这样的转换序列，返回 0。
// 所有单词具有相同的长度。
// 所有单词只由小写字母组成。
// 字典中不存在重复的单词。
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
//
//
// 示例 1:
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
//
//
// 示例 2:
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。
// Related Topics 广度优先搜索


import java.util.*;

public class WorkLadder127 {

    private static int minChangeNum = 0;

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(ladderLength(beginWord, endWord, wordList));

    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        dfs_helper(beginWord, endWord, wordList, 0, new boolean[wordList.size()]);

        return minChangeNum;
    }

    private static void dfs_helper(String beginWord, String endWord, List<String> wordList, int changeNum, boolean[] visited) {
        //如果转换成功，则直接返回转换次数
        if (beginWord.equals(endWord)) {
            if (minChangeNum == 0) {
                minChangeNum = changeNum + 1;
            } else {
                minChangeNum = Math.min(minChangeNum, changeNum + 1);
            }
            return;
        }

        int beginWordLen = beginWord.length();
        for (int k = 0; k < wordList.size(); k++) {
            if (visited[k]) {
                continue;
            }
            String word = wordList.get(k);
            if (beginWord.equals(word)) {
                visited[k] = true;
                continue;
            }
            int diffNum = 0;
            for (int i = 0; i < beginWordLen; i++) {
                if (beginWord.charAt(i) != word.charAt(i)) {
                    diffNum++;
                }
                if (diffNum > 1) {
                    break;
                }
            }
            if (diffNum == 1) {
                visited[k] = true;
                dfs_helper(word, endWord, wordList, changeNum + 1, visited);
                visited[k] = false;
            }
        }
    }
}

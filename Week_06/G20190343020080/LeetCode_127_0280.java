/**
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * Related Topics
 * 广度优先搜索
 *
 */

import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        int level = 1;
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<String>();
        Map<String, Set<String>> map = createMatchMap(wordList);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                visited.add(word);
                for (int j = 0; j < word.length(); j++) {
                    String newWord = word.substring(0, j)+"*"+word.substring(j+1, word.length());
                    Set<String> match = map.getOrDefault(newWord, new HashSet<String>());
                    if (match.contains(endWord)) {
                        return level+1;
                    }
                    for (String next : match) {
                        if (!visited.contains(next)) {
                            queue.offer(next);
                        }
                    }
                }
            }
            ++level;
        }
        return 0;
    }

    //对字典进行预操作，相当于建立图的邻接表
    private Map<String, Set<String>> createMatchMap (List<String> wordList) {
        Map<String, Set<String>> map = new HashMap<String, Set<String>>();
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            for (int j = 0; j < word.length(); j++) {
                String newWord = word.substring(0, j)+"*"+word.substring(j+1, word.length());
                Set<String> set;
                if (map.containsKey(newWord)) {
                    set = map.get(newWord);
                } else {
                    set = new HashSet<String>();
                    map.put(newWord, set);
                }
                if (!set.contains(word)) {
                    set.add(word);
                }
            }
        }
        return map;
    }

}
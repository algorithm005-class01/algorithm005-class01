package Week_03.G20190343020220.leetcode_126_0220;

/*给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：

每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。
说明:

如果不存在这样的转换序列，返回一个空列表。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
示例 1:

输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

输出:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
示例 2:

输入:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

输出: []

解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
*/

import java.util.*;

/**
 * @author Darcy
 * @date 2019-12-28 17:25
 */
public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // base condition
        Set<String> meets = new HashSet<>(wordList);
        if (!meets.contains(endWord)) {
            return Collections.emptyList();
        }

        Set<String> begin = new HashSet<>(Collections.singleton(beginWord));
        Set<String> end = new HashSet<>(Collections.singleton(endWord));

        // 相邻词映射
        Map<String, List<String>> neighborsMap = new HashMap<>();
        if (!doubleBfs(begin, end, neighborsMap, true, meets)) {
            return Collections.emptyList(); // not find
        }

        List<List<String>> result = new ArrayList<>();
        dfs(neighborsMap, result, beginWord, endWord, new LinkedList<>());
        return result;
    }

    // 双向广度优先，并确定在相遇时（找到最短路径时）所涉及的相邻词集合 neighbors
    private boolean doubleBfs(Set<String> begin, Set<String> end, Map<String, List<String>> neighborsMap,
                              boolean isFromBeginToEnd, Set<String> meets) {
        // terminator
        if (begin.size() == 0) {
            return false;
        }

        // process
        meets.removeAll(begin);

        // 在当前层是否已相遇
        boolean isMeetInCurrLevel = false;

        Set<String> nextLevels = new HashSet<>();
        // every word
        for (String beginWord : begin) {
            char[] arr = beginWord.toCharArray();
            // every letter
            for (int j = 0; j < arr.length; j++) {
                char swap = arr[j];
                // every other letter
                for (char i = 'a'; i <= 'z'; i++) {
                    arr[j] = i;
                    String newWord = String.valueOf(arr);
                    if (!meets.contains(newWord)) {
                        continue;
                    }

                    nextLevels.add(newWord);

                    // 记录相邻词映射
                    String key = isFromBeginToEnd ? beginWord : newWord;
                    String neighbor = isFromBeginToEnd ? newWord : beginWord;
                    if (!neighborsMap.containsKey(key)) {
                        neighborsMap.put(key, new ArrayList<>());
                    }
                    neighborsMap.get(key).add(neighbor);

                    // 而不是立刻返回，还要在这一层多找找
                    if (end.contains(newWord)) {
                        isMeetInCurrLevel = true;
                    }
                }
                arr[j] = swap;
            }
        }

        if (isMeetInCurrLevel) {
            return true;
        }

        // drill down
        // 少的找多的
        if (nextLevels.size() > end.size()) {
            return doubleBfs(end, nextLevels, neighborsMap, !isFromBeginToEnd, meets);
        } else {
            return doubleBfs(nextLevels, end, neighborsMap, isFromBeginToEnd, meets);
        }
    }

    // 深度优先，确定路径
    private void dfs(Map<String, List<String>> neighborsMap, List<List<String>> result,
                     String begin, String end, Deque<String> path) {
        // terminator: complete appending res, but path back to empty
        if (result.size() > 0 && path.size() == 0) return;

        // process
        path.addLast(begin); // add last 添加到路径末尾

        // 完成一条路径
        if (begin.equals(end)) {
            result.add(new ArrayList<>(path)); // 避免引用问题
        } else if (neighborsMap.containsKey(begin)) { // 有相邻词
            // drill down
            // 遍历相邻词并递归
            for (String neighbor : neighborsMap.get(begin)) {
                dfs(neighborsMap, result, neighbor, end, path);
            }
        }

        // back tracking
        path.removeLast(); // 退一步，以便找另一条路径
    }


}

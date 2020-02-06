//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
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


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {
    public static void main(String[] args) {
        Solution solution = new WordLadder().new Solution();
        List<String> list = List.of("hot", "dot", "dog", "lot", "log", "cog");

        System.out.println(solution.ladderLength("hit", "cog", new ArrayList<>(list)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<String> visited = new HashSet<>();

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> beginSet = new HashSet<>();
            Set<String> endSet = new HashSet<>();
            int count = 1;
            beginSet.add(beginWord);
            endSet.add(endWord);
            while (!beginSet.isEmpty() && !endSet.isEmpty()) {
                //优先选择少的遍历
                if (beginSet.size() > endSet.size()) {
                    Set<String> set = beginSet;
                    beginSet = endSet;
                    endSet = set;
                }
                Set<String> tmp = new HashSet<>();
                for (String word : beginSet) {
                    char[] chars = word.toCharArray();
                    for (int i = 0; i < word.length(); i++) {
                        for (char c = 'a'; c <= 'z'; c++) {
                            char old = chars[i];
                            chars[i] = c;
                            String target = String.valueOf(chars);
                            //相遇
                            if (endSet.contains(target)) {
                                return count + 1;
                            }
                            if (!visited.contains(target) && wordList.contains(target) && !target.equals(beginWord)) {
                                visited.add(target);
                                tmp.add(target);
                            }
                            chars[i] = old;
                        }
                    }
                }
                beginSet = tmp;
                count++;
            }
            return count;
        }

//        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//            if (!wordList.contains(endWord)) {
//                return 0;
//            }
//            Deque<String> queue = new LinkedList<>();
//            queue.add(beginWord);
//            int count = 0;
//            while (!queue.isEmpty()) {
//                String pop = queue.pop();
//                if (pop.equals(endWord)) {
//                    break;
//                }
//                char[] chars = pop.toCharArray();
//                boolean gotWord = false;
//                for (int i = 0; i < pop.length() && !gotWord; i++) {
//                    for (char c = 'a'; c <= 'z' && !gotWord; c++) {
//                        char old = chars[i];
//                        chars[i] = c;
//                        String target = String.valueOf(chars);
//                        if (!visited.contains(target) && wordList.contains(target) && !target.equals(beginWord)) {
//                            visited.add(target);
//                            queue.add(target);
//                            count++;
//                            gotWord = true;
//                        }
//                        chars[i] = old;
//                    }
//                }
//            }
//            System.out.println(visited);
//            return count;
//        }
//
//        private Set<String> getWord(String pop, String endWord, List<String> wordList) {
//            Set<String> tmp = new HashSet<>();
//
//            return tmp;
//        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
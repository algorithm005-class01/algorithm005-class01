package week06;

import java.util.*;
import javafx.util.Pair;

/**
 * Description: 单词接龙.
 *
 * @author Wengy
 * @since JDK 1.8
 * @since 1.0.0
 */
public class LeetCode_127_0314 {
  class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      HashMap<String, List<String>> dictionaryMap = new HashMap<>();
      for(String word : wordList) {
        for(int i=0; i<word.length(); i++) {
          String wordKey = word.substring(0, i) + "*" + word.substring(i+1, word.length());
          if(dictionaryMap.get(wordKey)==null) {
            List<String> list = new ArrayList<>();
            list.add(word);
            dictionaryMap.put(wordKey, list);
          } else {
            dictionaryMap.get(wordKey).add(word);
          }
        }
      }
      
      Deque<Pair<String, Integer>> deque = new LinkedList<>();
      deque.add(new Pair(beginWord, 1));
      
      HashSet<String> visitedSet = new HashSet<>();
      visitedSet.add(beginWord);
      
      while (!deque.isEmpty()) {
        Pair<String, Integer> wordPair = deque.remove();
        int depth = wordPair.getValue();
        
        for (int i = 0; i < beginWord.length(); i++) {
          List<String> list = dictionaryMap.get(wordPair.getKey().substring(0,i) + "*" + wordPair.getKey().substring(i+1, wordPair.getKey().length()));
          if(list!=null) {
            for(String element : list) {
              if (element.equals(endWord)) {
                return depth + 1;
              }
              if (!visitedSet.contains(element)) {
                visitedSet.add(element);
                deque.add(new Pair(element, depth + 1));
              }
            }
          }
        }
      }
      
      return 0;
      
    }
  }
}

package com.algorithm.week06;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LeetCode_127_0100 {

  //双端BFS
      public int ladderLength(String beginWord, String endWord, List<String> wordList) {
           Set<String> wordSet = new HashSet<>(wordList.size());
           wordSet.addAll(wordList);

           if (!wordSet.contains(endWord)) return 0;

           Set<String> s1 = new HashSet<>();
           Set<String> s2 = new HashSet<>();

           s1.add(beginWord);
           s2.add(endWord);
           int n = beginWord.length();
           int step = 0;
           while (!s1.isEmpty() && !s2.isEmpty()) {
               step++;
               if (s1.size() > s2.size()) {
                   Set<String> tmp = s1;
                   s1 = s2;
                   s2 = tmp;
               }
               Set<String> s = new HashSet<>();
               for (String word : s1) {
                   for (int i = 0; i < n; i++) {
                       char[] chars = word.toCharArray();
                       for (char ch = 'a'; ch <= 'z'; ch++) {
                           chars[i] = ch;
                           String tmp = new String(chars);
                           if (s2.contains(tmp)) return step + 1;
                           if (!wordSet.contains(tmp)) continue;
                           wordSet.remove(tmp);
                           s.add(tmp);
                       }
                   }
               }
               s1 = s;
           }
           return 0;
       }


//  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//    if (!wordList.contains(endWord)) return 0;
//
//    Set<String> wordSet = new HashSet(wordList.size());
//    wordSet.addAll(wordList);
//    if (wordSet.contains(beginWord)) wordSet.remove(beginWord);
//    if (wordSet.contains(endWord)) wordSet.remove(endWord);
//
//    int len = beginWord.length();
//    int index = 0;
//
//    Queue<String> s = new LinkedList();
//    s.add(beginWord);
//    while (!s.isEmpty()) {
//      String word = s.remove();
//      index++;
//      char[] tmp = word.toCharArray();
//      for (int i = 0; i < len; i++) {
//        for (char j = 'a'; j <= 'z'; j++) {
//          tmp[i] = j;
//          String tmpStr = new String(tmp);
//          if (tmpStr.equals(endWord)) return index;
//          if (! wordSet.contains(tmpStr)) continue;
//          s.add(tmpStr);
//          wordSet.remove(tmpStr);
//        }
//        tmp = word.toCharArray();
//      }
//    }
//    return index;
//  }
}

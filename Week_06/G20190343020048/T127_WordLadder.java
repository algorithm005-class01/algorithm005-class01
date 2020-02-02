package main.leetcode_solutions.search;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2020/1/19
 */
public class T127_WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0 || !wordList.contains(endWord)){
            return 0;
        }
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        int len = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()){
            if (beginSet.size() > endSet.size()){
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            Set<String> tmp = new HashSet<>();
            for (String s : beginSet){
                for (int i = 0; i < s.length(); i++){
                    char[] cs = s.toCharArray();
                    for (int k = 0; k < 26; k++){
                        cs[i] =  (char)('a' + k);
                        String ns = new String(cs);
                        if (endSet.contains(ns)){
                            return len + 1;
                        }
                        if (wordSet.contains(ns)){
                            tmp.add(ns);
                            wordSet.remove(ns);
                        }
                    }
                }
            }
            beginSet = tmp;
            len++;
        }
        return 0;
    }
}

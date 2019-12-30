package com.algorithm.week03;

import com.alibaba.fastjson.JSON;


import java.util.*;

/**
 * "hot"
 * "dog"
 * ["hot","dog","dot"]
 */

public class LeetCode_127_0100 {

    //BFS
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {

        Set<String> check = new HashSet<>(wordList);
        if (!check.contains(endWord)) return 0;
        if (beginWord.length() == 1 && endWord.length() == 1) return 1;

        //处理通配字
        Map<String, Set<String>> map = new HashMap<>();
        for (String word : wordList) {
            Set<String> keys = new HashSet<>();
            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char temp = arr[i];
                arr[i] = '*';
                keys.add(String.valueOf(arr));
                arr[i] = temp;
            }
            //可优化
            for (String key : keys) {
                if (!map.containsKey(key)) map.put(key, new HashSet<>());
                map.get(key).add(word);
            }
        }
        System.out.println(JSON.toJSONString(map));

        //进行BFS递归
        Set<String> visited = new HashSet<>();
        Deque<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.add(beginWord);

        int level = 0;

        while (!queue.isEmpty()) {
           String word = queue.pollFirst();

            for (int i = 0; i < word.length(); i++ ) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, word.length());

               Set<String> midWords = map.get(newWord);

               if (midWords == null || midWords.size() ==0 ) continue;
               for (String str : midWords) {
                    if(str.equals(endWord)) {
                        System.out.println(str);
                        return ++level;
                    }

                    if (!visited.contains(str)) {
                        System.out.println("add+"+str+" level:"+level);
                        queue.addLast(str);
                        visited.add(str);
                    }
               }
            }
            level++;
        }
        return 0;
    }

    //双向广度优先
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

    public static void main(String[] args) {
        LeetCode_127_0100 test = new LeetCode_127_0100();
        List<String>  list = Arrays.asList(new String[]{"hot","dog","dot"});
        List<String>  list2 = Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"});
        System.out.println(test.ladderLength("hot","dog",list));
        System.out.println(test.ladderLength("hit","cog",list2));
    }
}

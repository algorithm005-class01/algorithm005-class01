package main.leetcode_solutions.hashtable;


import java.util.*;

/**
 * @author wenzhuang
 * @date 2019/12/20
 */
public class T49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++){
            char[] cs = strs[i].toCharArray();
            Arrays.sort(cs);
            String key = String.valueOf(cs);
            if (!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(strs[i]);
        }
        return new ArrayList<List<String>>(map.values());
    }
}

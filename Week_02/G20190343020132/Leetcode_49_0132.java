package org.azai.train.Week02;

import java.util.*;

public class Leetcode_49_0132 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        if (strs.length == 0) {
            return result;
        }
        for(int i=0;i<strs.length;i++) {
            char[] current = strs[i].toCharArray();
            //将每个元素先进行排序
            Arrays.sort(current);
            String sorted = new String(current);
            //如果哈希表存在字母异位词则放入哈希表的value，不存在则新加入
            if (map.containsKey(sorted)) {
                map.get(sorted).add(strs[i]);
            }else{
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(sorted,list);
            }
        }
        map.forEach((x,y)->{
            result.add(y);
        });
        return result;
    }
}

package org.azai.train.Week02;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Leetcode_242_0132 {
    public boolean isAnagram1(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] result = new int[26];
        for (int i=0;i<s.length();i++) {
            result[s.charAt(i)-'a']++;
            result[t.charAt(i)-'a']--;
        }
        for(int x : result){
            if(x!=0){
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i),1);
            }
        }
        for (int j = 0;j<t.length();j++) {
            if (map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j),map.get(s.charAt(j))-1);
            }else{
                return false;
            }
        }
        Collection<Integer> list = map.values();
        for(Iterator<Integer> car = list.iterator();car.hasNext();) {
            if(car.next()!=0){
                return false;
            }
        }
        return true;
    }
}

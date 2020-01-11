package org.azai.train.Week03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_17_0132 {
    //递归
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits==null || digits.length() == 0) {
            return result;
        }
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        dfs(digits,0,"",result,map);
        return result;
    }
    public void dfs (String digits,int level,String cur,List<String> result,Map<Character,String> map) {
        if (level == digits.length()) {
            result.add(cur);
            return;
        }
        String target = map.get(digits.charAt(level));
        for (int i = 0;i<target.length();i++) {
            dfs(digits,level+1,cur+target.charAt(i),result,map);
        }
    }
}

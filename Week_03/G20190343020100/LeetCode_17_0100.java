package com.algorithm.week03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_17_0100 {
  public List<String> letterCombinations(String digits) {
    if (null == digits || "".equals(digits)) return new ArrayList<>();

    Map<Character,String> map = new HashMap<>();
    map.put('2',"abc");
    map.put('3',"def");
    map.put('4',"ghi");
    map.put('5',"jkl");
    map.put('6',"mon");
    map.put('7',"pqrs");
    map.put('8',"tuv");
    map.put('9',"wxyz");

    List<String> res = new ArrayList<>();

    myRecursion(res , "" , digits , 0 , map);
    return res;
  }

  public void myRecursion(List<String> res , String tmp , String digits , int index , Map<Character,String> map) {
    if (index == digits.length()) {
      res.add(tmp);
      return;
    }
    //回溯
    String letters =  map.get(digits.charAt(index));
    for (int i = 0 ; i < letters.length() ; i++) {
      char firstLetters = letters.charAt(i);
      myRecursion(res , tmp+firstLetters , digits , index + 1 , map);
    }
  }
}

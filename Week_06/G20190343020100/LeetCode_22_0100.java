package com.algorithm.week06;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_22_0100 {

  class Solution {
    //剪枝
    // public List<String> generateParenthesis(int n) {
    //     List<String> res = new ArrayList<String>();
    //     myRecursion(res,0,0,"",n);
    //     return res;
    // }

    // public void myRecursion(List<String> res , int ln , int rn , String tmp ,int n) {
    //     //返回条件
    //     if (tmp.length() >= 2*n) {
    //         res.add(tmp);
    //         return;
    //     }

    //     //做些什么 同时下探
    //         //1 添加左括号
    //         if (ln < n )
    //           myRecursion (res,ln+1,rn,tmp + "(",n);

    //         //2 添加右括号
    //         if (rn < ln)
    //            myRecursion (res,ln,rn+1,tmp + ")",n);

    //     //清除变量
    // }

    //DP
    public List<String> generateParenthesis(int n) {
      LinkedList<LinkedList<String>> result = new LinkedList<LinkedList<String>>();
      if (n == 0) {
        return result.get(0);
      }
      LinkedList<String> list0 = new LinkedList<String>();
      list0.add("");
      result.add(list0);
      LinkedList<String> list1 = new LinkedList<String>();
      list1.add("()");
      result.add(list1);
      for (int i = 2; i <= n; i++) {
        LinkedList<String> temp = new LinkedList<String>();
        for (int j = 0; j < i; j++) {
          List<String> str1 = result.get(j);
          List<String> str2 = result.get(i - 1 - j);
          for (String s1 : str1) {
            for (String s2 : str2) {
              String el = "(" + s1 + ")" + s2;
              temp.add(el);
            }
          }
        }
        result.add(temp);
      }
      return result.get(n);
    }
  }

}

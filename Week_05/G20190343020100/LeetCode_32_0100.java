package com.algorithm.week05;

public class LeetCode_32_0100 {

  public int longestValidParentheses(String s) {
    //subproblem : 一个"（"  需要对应 "）"
    //如果当前  ） 判断上一个是不是 （
    //如果当前  ） 上一个是 ） 则下班移动n个括弧判断之前是不是（
    //定义状态数组 dp[] 存放括弧对数
    //寻找DP公式
    //当前为 （  dp[i] = 0
    //当前 ） 且 i - 1 =（   dp[i] = dp[i - 2] + 2
    //当前 ） 且 移动 dp[i - 1] 的括弧数  - 1 是否为 （  dp[i] =dp[i - dp[i - 1] - 1]
    if (s == null || s.length() == 0) {
      return 0;
    }
    int[] dp = new int[s.length()];
    int res = 0;
    for (int i = 1; i < s.length(); i++) {
      //无需判断 ‘（ ’ 只需要判断 ‘ ）’
      if (i > 0 && s.charAt(i) == ')') {
        if (s.charAt(i - 1) == '(') {
          dp[i] = i - 2 < 0 ? 2 : dp[i - 2] + 2;
        } else if (s.charAt(i - 1) == ')' && i - dp[i - 1] - 1 >= 0
            && s.charAt(i - dp[i - 1] - 1) == '(') {
          dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 < 0 ? 0 : dp[i - dp[i - 1] - 2]);
        }
      }
      res = Math.max(res, dp[i]);
    }
    return res;
  }
}

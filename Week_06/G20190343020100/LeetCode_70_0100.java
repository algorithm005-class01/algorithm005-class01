package com.algorithm.week06;

public class LeetCode_70_0100 {
  // public int climbStairs(int n) {
  //     if ( n == 1 ) {
  //         return 1;
  //     }
  //     // f(n) = f(n-1) + f(n-1)
  //     int first = 1;
  //     int second = 2;
  //     for (int i = 3 ; i <= n ; i++ ) {
  //         int fn = first + second;
  //         first = second;
  //         second = fn;
  //     }
  //     return second;
  // }

  //DP
  public int climbStairs(int n) {
    if (n == 1 || n == 2) return n;

    //定义状态数组
    int[] fn = new int[n + 1];
    //技术处理
    fn[1] = 1;
    fn[2] = 2;
    //地推公式 fn = fn[n - 1] + fn[n - 2];
    for (int i = 3; i < n + 1; i++) {
      fn[i] = fn[i - 1] + fn [i - 2];
    }
    return fn[n];
  }


//暴力递归 O(2^n)
  // public int climbStairs(int n) {
  //     if (n == 1 || n == 2) return n;
  //     return recursion(0, n);
  // }

  // public int recursion(int i,int n) {
  //     // terminated
  //     if (i > n) return 0;
  //     if (i == n) return 1;

  //     //process
  //     //drill down
  //     return  recursion(i + 1,n) + recursion(i + 2,n);
  // }

}

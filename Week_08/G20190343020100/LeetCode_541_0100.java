package com.algorithm.week08;

public class LeetCode_541_0100 {

  public String reverseStr(String s, int k) {
    char[] a = s.toCharArray();
    //跳跃移动窗口
    for (int i = 0; i < s.length(); i += 2 * k) {
      int x = i, y = Math.min(i + k - 1, a.length - 1);
      //使用首尾指针交换顺序
      while (x < y) {
        char tmp = a[x];
        a[x++] = a[y];
        a[y--] = tmp;
      }
    }
    return new String(a);
  }

  public static void main(String[] args) {
    LeetCode_541_0100 test = new LeetCode_541_0100();
    String val = test.reverseStr("acbadrutgd",2);
    System.out.println(val);
  }
}

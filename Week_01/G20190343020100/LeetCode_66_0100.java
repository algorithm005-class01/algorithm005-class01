package com.algorithm.week01;

public class PlusOne {
  public int[] plusOne(int[] digits) {
    // 倒叙处理
    // 循环到的数++
    // 并且%10 如果摸出来不是0 说明没发生 进位 直接返回
    // 如果为0 则发生进位，需要往下一步处理
    // 特例情况 999或 9999 ...  需要新建数组 长度+1 首位为1
    // 题中告知都是但个数，说明只能【0-9】 所以不必担心溢出问题

    for (int i = digits.length-1; i >= 0; i--) {
      digits[i]++;
      digits[i] = digits[i]%10;
      if (digits[i] != 0) return digits;
    }
    digits = new int[digits.length +1];
    digits[0] = 1;
    return digits;
  }
}
//runtime:0 ms
//memory:35.1 MB

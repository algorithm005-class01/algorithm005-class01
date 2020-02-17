package com.algorithm.week08;

public class LeetCode_387_0100 {
  //双指针暴力
//     public int firstUniqChar(String s) {
//         if (s.length() == 0) return -1;

//         for (int i = 0; i < s.length(); i++) {
//             char first = s.charAt(i);
//             int count = 0;
//             for (int j = i + 1; j < s.length(); j++) {
//                 char second = s.charAt(j);
//                 if (first == second) {
//                     count ++;
//                 }
//             }
//             if (count == 1)
//                 return i;
//         }
//         return -1;
//     }

  //字符数组存起来缓存字典
  public int firstUniqChar(String s) {
    if (s.length() == 0)
      return -1;
    if (s.length() == 1)
      return 0;

    int[] tab = new int[26];

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      tab[c - 'a']++;
    }

    for (int k = 0; k < s.length(); k++) {
      char c = s.charAt(k);
      if (tab[c - 'a'] == 1)
        return k;
    }
    return -1;
  }

  public static void main(String[] args) {
    LeetCode_387_0100 test = new LeetCode_387_0100();
    int val = test.firstUniqChar("leetcodelove");
    System.out.println(val);
  }

}

/**
 * 题目：字母异位词分组
 * 链接：https://leetcode-cn.com/problems/valid-anagram/description/
 * 详情：
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 */

/**
 * 思路：
 * 将两个字符串排序，排序后，如果两个字符串相等，则为异位词
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        return sortString(s).equals(sortString(t));
    }

    public String sortString(String inputString) {
        // convert input string to char array
        char tempArray[] = inputString.toCharArray();
        // sort tempArray
        Arrays.sort(tempArray);
        // return new sorted string
        return new String(tempArray);
    }
}


/*
附上官方解法，以供后续学习


public boolean isAnagram(String s, String t) {
      if (s.length() != t.length()) {
            return false;
      }
      char[] str1 = s.toCharArray();
      char[] str2 = t.toCharArray();
      Arrays.sort(str1);
      Arrays.sort(str2);
      return Arrays.equals(str1, str2);
}

官方解法2
public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
    int[] table = new int[26];
    for (int i = 0; i < s.length(); i++) {
        table[s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < t.length(); i++) {
        table[t.charAt(i) - 'a']--;
        if (table[t.charAt(i) - 'a'] < 0) {
            return false;
        }
    }
    return true;
}

 */
 
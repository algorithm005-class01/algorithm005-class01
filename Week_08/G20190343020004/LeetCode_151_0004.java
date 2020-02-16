package com.zyh.test.leetcode;

public class LeetCode_151_0004 {

    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        s = s.trim();
        if (s.length() < 2) {
            return s;
        }
        String[] parts = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = parts.length - 1; i >= 0; i--) {
            if (parts[i].length() == 0 || parts[i].equals(" ")) {
                continue;
            }
            sb.append(parts[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}

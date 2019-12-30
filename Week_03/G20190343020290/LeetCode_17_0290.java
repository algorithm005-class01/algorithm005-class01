package com.jtel.ekoo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Ju·Felix on 2019/12/29.
 */
public class LeetCode_17_0290 {
    public static void main(String[] args) {
        String num = "23";
        List<String> letters = letterCombinations(num);
        String result = letters.stream().collect(Collectors.joining(","));
        System.out.println(result);
    }

    private static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (null == digits || digits.length() == 0) {
            return combinations;
        }
        int size = digits.length();
        char[] word = new char[size];
        char[][] allChars = new char[size][];
        int[] curValue = new int[size];
        int total = 1;
        for (int i = 0; i < size; i++) {
            allChars[i] = getDigitCharArray(digits.charAt(i));
            word[i] = allChars[i][0];
            curValue[i] = 0;
            total = total * allChars[i].length;
        }
        for (int i = 0; i < total; i++) {
            combinations.add(new String(word));
            int curPos = size - 1;
            boolean hasCarry = true;
            while (hasCarry) {
                hasCarry = false;
                curValue[curPos]++;
                if (curValue[curPos] == allChars[curPos].length) {
                    curValue[curPos] = 0;
                    hasCarry = true;
                }
                word[curPos] = allChars[curPos][curValue[curPos]];
                if (hasCarry && curPos > 0) {
                    curPos--;
                }
            }
        }
        return combinations;
    }

    private static char[] getDigitCharArray(char digit) {
        switch (digit) {
            case '2':
                return new char[]{'a', 'b', 'c'};
            case '3':
                return new char[]{'d', 'e', 'f'};
            case '4':
                return new char[]{'g', 'h', 'i'};
            case '5':
                return new char[]{'j', 'k', 'l'};
            case '6':
                return new char[]{'m', 'n', 'o'};
            case '7':
                return new char[]{'p', 'q', 'r', 's'};
            case '8':
                return new char[]{'t', 'u', 'v'};
            case '9':
                return new char[]{'w', 'x', 'y', 'z'};
            default:
                return new char[0];
        }
    }
}

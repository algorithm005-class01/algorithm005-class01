package main.leetcode_solutions.backtracking;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2019/12/28
 */
public class T17_LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0){
            return res;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        StringBuilder sb = new StringBuilder();
        backtrack(0, digits, sb, res, map);
        return res;
    }

    private void backtrack(int index, String digits, StringBuilder sb, List<String> res, Map<Character, String> map){
        if (index == digits.length()){
            res.add(sb.toString());
            sb = new StringBuilder();
            return;
        }
        char c = digits.charAt(index);
        String str = map.get(c);
        for (int i = 0; i < str.length(); i++){
            sb.append(str.charAt(i));
            backtrack(index + 1, digits, sb, res, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

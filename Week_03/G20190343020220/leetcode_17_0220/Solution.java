package Week_03.G20190343020220.leetcode_17_0220;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Darcy
 * @date 2019-12-27 14:24
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>(8);
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> ans = new ArrayList<>();
        letterCombinationsHelper("", digits, ans, 0, map);
        return ans;


    }

    private void letterCombinationsHelper(String s, String digits, List<String> ans, int level, Map<Character, String> map) {
        if (level == digits.length()) {
            ans.add(s);
            return;
        }

        String letter = map.get(digits.charAt(level));
        for (int i = 0; i < letter.length() - 1; i++) {
            letterCombinationsHelper(s + letter.charAt(i), digits, ans, level + 1, map);
        }

    }
}

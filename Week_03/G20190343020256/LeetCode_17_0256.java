package Week3;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 */

public class LeetCode_17_0256 {

    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};


    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits != null && digits.length() != 0) {
            backtrack(result, "", digits);
        }
        return result;
    }
    private void backtrack(List<String> output, String combination, String next_digits) {
        if (next_digits.length() == 0) {
            output.add(combination);
            return;
        } else {
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);



            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i+1);

                backtrack(output, combination + letter, next_digits.substring(1));

            }
        }
    }

}

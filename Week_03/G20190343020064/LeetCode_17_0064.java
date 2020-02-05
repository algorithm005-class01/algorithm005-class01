package G20190343020064;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * <p>
 * 电话号码的字母组合
 * </p>
 *
 * @author mingke.yan@hand-china.com 2019-12-26 4:36 下午
 */
public class LeetCode_17_0064 {


    private static List<String> result = new ArrayList<>();

    private static Map<String, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        this.letterCombinations(digits, map, 0,"");
        return result;
    }

    public void letterCombinations(String digits, Map<String, String> map, int index, String string) {
        System.out.println(digits);
        System.out.println(index);

        if (index == digits.length()) {
            if (!"".equals(string)) {
                result.add(string);
            }
            return;
        }
        String str  = map.get(String.valueOf(digits.charAt(index)));
        for(int i = 0; i < str.length(); i++) {
            this.letterCombinations(digits, map, index + 1, string + str.charAt(i));
        }
    }


}

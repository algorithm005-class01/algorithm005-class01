package G20190343020064;

import java.util.ArrayList;
import java.util.Collections;
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

    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)) {
            return Collections.emptyList();
        }
        char[] chars = digits.toCharArray();
        this.combinations(chars, 0, new char[digits.length()]);
        return result;
    }

    public void combinations(char[] chars, int n, char[] str) {
        if (n == chars.length) {
            result.add(new String(str));
            return;
        }

        switch (chars[n]) {
            case '2':
                str[n] = 'a';
                combinations(chars, n + 1, str);
                str[n] = 'b';
                combinations(chars, n + 1, str);
                str[n] = 'c';
                combinations(chars, n + 1, str);
                break;
            case '3':
                str[n] = 'd';
                combinations(chars, n + 1, str);
                str[n] = 'e';
                combinations(chars, n + 1, str);
                str[n] = 'f';
                combinations(chars, n + 1, str);
                break;
            case '4':
                str[n] = 'g';
                combinations(chars, n + 1, str);
                str[n] = 'h';
                combinations(chars, n + 1, str);
                str[n] = 'i';
                combinations(chars, n + 1, str);
                break;
            case '5':
                str[n] = 'j';
                combinations(chars, n + 1, str);
                str[n] = 'k';
                combinations(chars, n + 1, str);
                str[n] = 'l';
                combinations(chars, n + 1, str);
                break;
            case '6':
                str[n] = 'm';
                combinations(chars, n + 1, str);
                str[n] = 'n';
                combinations(chars, n + 1, str);
                str[n] = 'o';
                combinations(chars, n + 1, str);
                break;
            case '7':
                str[n] = 'p';
                combinations(chars, n + 1, str);
                str[n] = 'q';
                combinations(chars, n + 1, str);
                str[n] = 'r';
                combinations(chars, n + 1, str);
                str[n] = 's';
                combinations(chars, n + 1, str);
                break;
            case '8':
                str[n] = 't';
                combinations(chars, n + 1, str);
                str[n] = 'u';
                combinations(chars, n + 1, str);
                str[n] = 'v';
                combinations(chars, n + 1, str);
                break;
            case '9':
                str[n] = 'w';
                combinations(chars, n + 1, str);
                str[n] = 'x';
                combinations(chars, n + 1, str);
                str[n] = 'y';
                combinations(chars, n + 1, str);
                str[n] = 'z';
                combinations(chars, n + 1, str);
                break;
        }


    }

}

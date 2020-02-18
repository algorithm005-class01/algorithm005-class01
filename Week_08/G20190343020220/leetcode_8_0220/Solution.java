package Week_08.G20190343020220.leetcode_8_0220;

/**
 * @author Darcy
 * @date 2020-02-16 20:03
 */
public class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }

        int sign = 1;
        int start = 0;
        long res = 0;
        char c = str.charAt(0);
        if (c == '+') {
            start++;
        } else if (c == '-') {
            sign = -1;
            start++;
        }
        for (int i = start; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int) res * sign;
            }
            res = res * 10 + str.charAt(i) - '0';
            if (sign == 1 && res > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign == -1 && res > Integer.MAX_VALUE)
                return Integer.MIN_VALUE;
        }

        return (int) res * sign;
    }
}

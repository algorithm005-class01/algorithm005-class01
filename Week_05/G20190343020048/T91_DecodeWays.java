package main.leetcode_solutions.dynamic_programming;

/**
 * @author wenzhuang
 * @date 2020/1/12 11:39 PM
 */
public class T91_DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        if (s.charAt(0) == '0'){
            return 0;
        }
        int pre2 = 1, pre1 = 1;
        for (int i = 2; i <= s.length(); i++){
            boolean one = s.charAt(i - 1) != '0';
            int num = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
            boolean two = (num >= 10) && (num <= 26);
            if (!one && !two){
                return 0;
            }
            int cur = 0;
            if (one){
                cur += pre1;
            }
            if (two){
                cur += pre2;
            }
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}

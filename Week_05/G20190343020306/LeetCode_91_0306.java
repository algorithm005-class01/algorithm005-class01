class Solution {
    /*
    f(i)为下标i的子串的解码方法
    f(0) = 1
    f(1) = 1 if number(a(0), a(1)) > 26 else 2
    f(i) = f(i-1) if number(a(i-1), a(i)) > 26 else f(i-1) + f(i-2)
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int dp[] = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(i-1)).append(s.charAt(i));
            //当前字符为0, 只有一种编码方式就是与前一个结合
            if (s.charAt(i) == '0') {
                if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2') {
                    dp[i] = (i >= 2? dp[i-2]: 1);
                } else {
                    return 0; //无法解码
                }
            }
            //当前字符不为0, 看前一个字符是否为0, 或者当前字符跟前一个字符无法组合
            else if (s.charAt(i-1) == '0' || Integer.parseInt(sb.toString()) > 26) {
                dp[i] = dp[i-1];
            }
            //以上都不是的情况, 当前字符单独解码(解码方法不多加一次), 以及与前一个字符组合的解码
            else {
                dp[i] = (i >= 2 ? dp[i-1] + dp[i-2]: dp[i-1] + 1);
            }
        }
        return dp[s.length()-1];
    }
}
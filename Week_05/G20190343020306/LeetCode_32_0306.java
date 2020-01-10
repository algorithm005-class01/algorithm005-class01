/*
    LeetCode 32
    看了官方题解自己想一下:
    设f(i)为以下标i结束的最长有效括号子串长度
    1. f(i)肯定以')'结尾, 如果不是f(i) = 0
    2. 如果a[i-1]='(', 那么f(i) = f(i-2) + 2, 因为最后两个字符形成有效子串
    3. 如果a[i-1]=')', 这个时候a[i] = ')', 如果要形成一个以a[i]结尾的有效子串,
       那么a[i]对应的左括号肯定在a[i-1]对应的最长有效字串的前面,
       即i - f(i-1) - 1的位置, 如果a[i - f(i-1) - 1]='('，那么f(i) = f(i-1) + f(i-f(i-1)-2) + 2,
       注意需要把再前面的子串也带上
       如果它!='(', 或者前面没有字符了, 就不可能形成一个有效子串, 那么f(i)保持为0即可
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            dp[i] = 0;
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = i >= 2 ? dp[i - 2] + 2 : 2;
                } else {
                    if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                }
            }
            max = Math.max(dp[i], max);
        }

        return max;
    }
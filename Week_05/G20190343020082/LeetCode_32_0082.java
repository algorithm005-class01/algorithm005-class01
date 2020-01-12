class LeetCode_32_0082 {
	public int longestValidParentheses(String s) {
		if (s.length() < 2) return 0;
		int[] dp = new int[s.length()];
		int maxLength = 0;
		for (int i = 1; i < dp.length; i ++) {
			if (s.charAt(i) == ')') {
				if (s.charAt(i -1) == '(') {
					dp[i] = i >=2 ? dp[i - 2] + 2 : 2;
				} else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
					dp[i] = i - dp[i - 1] - 2 > 0 ? dp[i - 1] + dp[i - dp[i - 1] - 2] + 2 : dp[i - 1] + 2;
				}
			}
			maxLength = Math.max(dp[i], maxLength);
		}
		return maxLength;
	}
}
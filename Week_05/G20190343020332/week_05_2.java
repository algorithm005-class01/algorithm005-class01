class Solution {
	
		// 穷举法
		public int longestValidParentheses(String s) {
        int longest = 0;
        for(int i = 0; i < s.length(); i++)
            for(int j = i + 2; j <= s.length(); j+=2)
                if(isValidParentheses(s.substring(i, j)))
                    longest = Math.max(longest, j-i);
        return longest;            
    }

    public boolean isValidParentheses(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(')
                stack.push('(');
            else if(!stack.empty())
                stack.pop();
            else 
                return false;
        }
        return stack.empty();
    }
	
	  // 动态规划
    public int longestValidParentheses(String s) {
        int longest = 0;
        int dp[] = new int [s.length()];
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '(')
                    dp[i] = (i >= 2 ? dp[i-2] : 0) + 2;
                else if(i > dp[i-1] && s.charAt(i-dp[i-1]-1) == '(')
                    dp[i] = dp[i-1] + 2 + (i-dp[i-1] >= 2 ? dp[i-dp[i-1]-2] : 0);
                longest = Math.max(longest, dp[i]);
            }
        }
        return longest;            
    }


    
}
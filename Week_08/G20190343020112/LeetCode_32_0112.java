class Solution {
    public int longestValidParentheses(String s) {
        int ans = 0;
        int[] dp = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = i > 1 ? dp[i - 2] + 2 : 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                } 
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}


// class Solution {
//     public int longestValidParentheses(String s) {
//         int count = 0, res = 0, cur = 0;
//         // 从左往右遍历一遍，遇到‘（’，count+1
//         // 遇见')'，count-1
//         // 如果count==0,说明目前遍历过的这个字串是有效的
//         // 如果count<0,说明遍历的这段是无效的，重置count的值,下个字符重新开始
//         for (int i = 0; i < s.length(); i++) {
//             if (s.charAt(i) == '(') count++;
//             else count--;
//             if (count > 0) {
//                 cur++;
//             }else if (count == 0) {
//                 res = Math.max(res, ++cur);
//             } else {
//                 cur = 0;
//                 count = 0;
//             }
//         }
//         count=0;
//         cur = 0;
//         // 从右往左遍历一遍，因为从左往右，无法计算((()，左括号多的情况，因为遇不count==0的情况。
//         for (int i = s.length() - 1; i >= 0; i--) {
//             if (s.charAt(i) == ')') count++;
//             else count--;
//             if (count > 0) {
//                 cur++;
//             }else if (count == 0) {
//                 res = Math.max(res, ++cur);
//             } else {
//                 cur = 0;
//                 count = 0;
//             }
//         }
//         return res;
//     }
// }
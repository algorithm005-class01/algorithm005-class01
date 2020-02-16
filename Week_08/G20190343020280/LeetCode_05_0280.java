//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
// 示例 1：
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
//
//
// 示例 2：
//
// 输入: "cbbd"
//输出: "bb"
//
// Related Topics 字符串 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        //dp方程 dp[i][j]表示子串s.sub(i,j)是否是回文串， dp[i][j]=dp[i+1][j-1] && s[i]==s[j]
        String result = "";
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        for (int i = length-1; i>=0; i--) {
            for (int j = i; j < length; j++) {
                dp[i][j] = s.charAt(i)==s.charAt(j) &&
                        (j-i<2 || dp[i+1][j-1]);
                if (dp[i][j] && result.length()<j-i+1) {
                    result = s.substring(i,j+1);
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
